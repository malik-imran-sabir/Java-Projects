package org.api.services.impl;

import java.util.Date;
import java.util.List;

import org.api.model.jpa.entity.UserAuthorityEntity;
import org.api.model.jpa.entity.UserEntity;
import org.api.vo.CommonUserVO;
import org.api.vo.UserVO;
import org.core.service.CRUDService;
import org.core.view.JSONResponse;
import org.springframework.http.ResponseEntity;

public interface UserService extends CRUDService<UserVO>{
	
	public ResponseEntity<JSONResponse<?>> usersByType(long userTypeId);
	
	public ResponseEntity<JSONResponse<?>> userDetail();
	
	public ResponseEntity<JSONResponse<?>> saveUpdateUser(CommonUserVO student, String imagePath);
	
	public ResponseEntity<JSONResponse<?>> saveImages(CommonUserVO student, String imagePath);
	
	public ResponseEntity<JSONResponse<?>> Liststudents(long teacherId);
	
	public ResponseEntity<JSONResponse<?>> getstudentlist();
	
	
	public ResponseEntity<JSONResponse<?>> getUser(long id);
	
	public ResponseEntity<JSONResponse<?>> getUserDetails(long id);
	
	public UserAuthorityEntity saveUserAuthority(UserEntity insertedUser,  Date currentTime);
	
	public ResponseEntity<JSONResponse<?>> usersByTypeAndMadarsa(List<Long> madarsaId, String userTypeId);
	
	public ResponseEntity<JSONResponse<?>> allUserList();
	
	public ResponseEntity<JSONResponse<?>> salaryReportList();
	
	public ResponseEntity<JSONResponse<?>> monthlyAttendanceReport();
	
	public ResponseEntity<JSONResponse<?>> salaryRegisterReport();
	
	public ResponseEntity<JSONResponse<?>> userexist(String username);
	
	public ResponseEntity<JSONResponse<?>> getStudentCount();
	
	public ResponseEntity<JSONResponse<?>> getTeacherCount();
	
	public ResponseEntity<JSONResponse<?>> getDecoded(String pwd);
	
}
