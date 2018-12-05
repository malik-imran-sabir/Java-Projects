package org.api.controllers;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.api.services.impl.UserService;
import org.api.vo.CommonUserVO;
import org.core.service.CRUDService;
import org.core.util.FileUploadUtils;
import org.core.view.JSONResponse;
import org.core.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Class StudentController.
 */
@Controller
@RequestMapping("/student")
public class StudentController extends BaseController<CommonUserVO> {
	
	/** The user service. */
	@Autowired
	private UserService userService;

	/** The Constant extention. */
	private final static String extention = ".jpeg";
			
	/**
	 * Instantiates a new student controller.
	 *
	 * @param service the service
	 */
	@Autowired
	public StudentController(CRUDService<CommonUserVO> service) {
		super(service);
	}

	/**
	 * Save update user.
	 *
	 * @param user the user
	 * @param request the request
	 * @return the response entity
	 */
	@PostMapping("/save")
	public ResponseEntity<JSONResponse<?>> saveUpdateUser(@RequestBody CommonUserVO user, HttpServletRequest request) {
		
		//System.getProperty("user.dir")
		
		String imagePath ="";
		
		imagePath = FileUploadUtils.getBasePath(request) 
				+ File.separatorChar 
				+ FileUploadUtils.randomAlphaNumeric(10) 
				+ extention;
		
		if(request.getSession()==null) {
			
			imagePath = System.getProperty("user.dir")
					+ File.separatorChar 
					+ FileUploadUtils.randomAlphaNumeric(10) 
					+ extention;
			
		}
		
	/*	try {
			
			UserVO userVo  = BeanUtils.shallowCopy(user, UserVO.class);
			UserDetailsVO userdetailsVO  = BeanUtils.shallowCopy(user, UserDetailsVO.class);
			long id = user.getId();
			userVo.setId(id);
			userService.update(userVo);
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		*/
		
	/*	if(user.getImageString()!=null) {
			saveimage(user);
		}*/
		
		
		
		return userService.saveUpdateUser(user, imagePath);
	}

	/**
	 * Gets the user.
	 *
	 * @param id the id
	 * @return the user
	 */
	@GetMapping("/list/{id}")
	public ResponseEntity<JSONResponse<?>> getUser(@PathVariable("id") long id) {
		return userService.getUser(id);
	}
	
	@GetMapping("/saveimage")
	public ResponseEntity<JSONResponse<?>> saveimage(@RequestBody CommonUserVO user) {
		
	
		
		String imagePath =System.getProperty("user.dir")
				+ File.separatorChar 
				+ FileUploadUtils.randomAlphaNumeric(10) 
				+ extention;
		try {
			

		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		
		return userService.saveImages(user,imagePath);
	}
}
