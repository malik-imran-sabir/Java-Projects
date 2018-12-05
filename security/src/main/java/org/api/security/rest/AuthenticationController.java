package org.api.security.rest;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.api.security.auth.JwtAuthenticationRequest;
import org.api.security.common.DeviceProvider;
import org.api.security.model.UserEntity;
import org.api.security.model.UserTokenState;
import org.api.security.model.UserTokenState_1;
import org.api.security.model.UserVO;
import org.api.security.security.TokenHelper;
import org.api.security.service.UserService;
import org.api.security.service.impl.CustomUserDetailsService;
import org.core.util.JsonUtil;
import org.core.util.RestApiUtil;
import org.core.view.JSONResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import io.jsonwebtoken.Claims;

/**
 * Created by fan.jin on 2017-05-10.
 */

/*@RestController
@RequestMapping( value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE )*/
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	//private static String URL_API_HOST = "http://jpcloudusa004.nshostserver.net:33226";
	private static String URL_API_HOST = "http://localhost:8080";

	@Value("${api.location}")
	private static String URL_LOCATION_API= URL_API_HOST+"/locations/locationData/";
	@Value("${api.users}")
	private static String URL_USERS_API= URL_API_HOST+"/users/user/";
	@Value("${api.organizations}")
	private static String URL_MADARSA_API = URL_API_HOST+"/org//org/branch/";
	
	private static String teacherType = "2";
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	  
    @Autowired
    TokenHelper tokenHelper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;
    
    @Autowired
    private DeviceProvider deviceProvider;

    @Value("AUTH-TOKEN")
    private String TOKEN_COOKIE;
    
    //@RequestMapping(value = "/login", method = RequestMethod.POST)
    @PostMapping("/login")
    public ResponseEntity<JSONResponse<?>> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest,
            HttpServletResponse response,
            Device device
    ) throws AuthenticationException, IOException {
      
    	try {
	    	// Perform the security
    		
    		
    		
    		
	        final Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        authenticationRequest.getUsername(),
	                        authenticationRequest.getPassword()
	                )
	                
	        );
	        
	        
	        // Inject into security context
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        UserEntity user = (UserEntity)authentication.getPrincipal();
	        String password =authenticationRequest.getPassword(); 
	        
	        user.setPassword(null);
	        
	        
	
	        UserVO users = userService.findByUsername(user.getUsername());
	        
	        try {
	        	//String apiResult = RestApiUtil.consumeRestCall(URL_LOCATION_API + users.getLocation());
	        	
				users.setPasswordSalt(password);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	       
	        
	        //users.setPassword(password);
	      //  String location = RestApiUtil.consumeRestCall(URL_USERS_API);
	       
	        try {
	        	 String apiResult = RestApiUtil.consumeRestCall(URL_LOCATION_API + users.getLocation());
	  	       String location = RestApiUtil.getJsondata("value", apiResult);
	  	      // users.setLocation(location);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	      
			
			if(teacherType.equals(users.getUserTypeId())) {
				try {
					String madarsaApi = RestApiUtil.consumeRestCall(URL_MADARSA_API + users.getMadarsaId());
					String name = RestApiUtil.getJsondata("name", madarsaApi);
					users.setMadarsa(name);
					
					String nigran = RestApiUtil.getJsondata("nigranid", madarsaApi);
					String nigranApi = RestApiUtil.consumeRestCall(URL_USERS_API + nigran);
					String nigranName = RestApiUtil.getJsondata("name", nigranApi);
					users.setNigran(nigranName);
					
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			
			}
	        // token creation
	        String jws = tokenHelper.generateToken( user.getUsername(), device);
	        int expiresIn = tokenHelper.getExpiredIn(device);
	        //adding token to cookie
	        response.addCookie( createAuthCookie( jws, expiresIn ) );

	        users.setToken(jws);
	        users.setExpiresIn(expiresIn);

            // return ResponseEntity.ok(new UserTokenState(jws, expiresIn, users));
	        // Return the token
	       return JsonUtil.convertSingleEntityToJson(users);
	        
    	} catch(BadCredentialsException e) {
    		e.printStackTrace();
    		logger.error(e.getLocalizedMessage());
    		return JsonUtil.JsonForError(e.getMessage());
    	} catch(HttpServerErrorException e) {
    		e.printStackTrace();
    		logger.error(e.getLocalizedMessage());
    		return JsonUtil.JsonForError(e.getMessage());
    	} catch(HttpClientErrorException e) {
    		e.printStackTrace();
    		logger.error(e.getLocalizedMessage());
    		return JsonUtil.JsonForError(e.getMessage());
    	}
    }

    
    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    public ResponseEntity<?> refreshAuthenticationToken(
            HttpServletRequest request,
            HttpServletResponse response,
            Principal principal
            ) {

        String authToken = tokenHelper.getToken( request );

        Device device = deviceProvider.getCurrentDevice(request);

        if (authToken != null && principal != null) {

            // TODO check user password last update
            String refreshedToken = tokenHelper.refreshToken(authToken, device);
            int expiresIn = tokenHelper.getExpiredIn(device);

            return ResponseEntity.ok(new UserTokenState_1(refreshedToken, expiresIn));
        } else {
            UserTokenState_1 userTokenState = new UserTokenState_1();
            return ResponseEntity.accepted().body(userTokenState);
        }
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> changePassword(@RequestBody PasswordChanger passwordChanger) {
        userDetailsService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword);
        Map<String, String> result = new HashMap<>();
        result.put( "result", "success" );
        return ResponseEntity.accepted().body(result);
    }

    static class PasswordChanger {
        public String oldPassword;
        public String newPassword;
    }
    
    @GetMapping("/validateToken")
    public String validateToken(@CookieValue("AUTH-TOKEN") String token) {
    	Claims claim = tokenHelper.getAllClaimsFromToken(token);
    	String user = claim.getSubject();
    	return (user==null || "".equals(user)) ? "invalid token" :  user ;
    }
    
    private Cookie createAuthCookie(String jwt, int expiresIn) {
        Cookie authCookie = new Cookie( TOKEN_COOKIE, ( jwt ) );
        authCookie.setPath( "/" );
        authCookie.setHttpOnly( true );
        authCookie.setMaxAge( expiresIn );
        return authCookie;
    }
    
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String createAuthenticationToken(){
    	return "Hello World";
    }
}