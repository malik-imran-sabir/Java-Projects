package org.api.security.service;

import java.util.List;

import org.api.security.model.UserEntity;
import org.api.security.model.UserVO;
import org.core.view.JSONResponse;
import org.springframework.http.ResponseEntity;

import io.jsonwebtoken.Claims;

/**
 * Created by fan.jin on 2016-10-15.
 */
public interface UserService {
	UserEntity findById(Long id);
	UserVO findByUsername(String username);
    List<UserEntity> findAll ();
    Claims validateToken(String token, UserEntity user);
}
