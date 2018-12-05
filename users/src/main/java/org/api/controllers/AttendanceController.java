package org.api.controllers;

import org.api.services.impl.AttendanceService;
import org.api.vo.AttendanceBulkVO;
import org.api.vo.AttendanceVO;
import org.core.service.CRUDService;
import org.core.view.JSONResponse;
import org.core.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class AttendanceController extends BaseController<AttendanceVO> {
	
	@Autowired
	AttendanceService attendanceService;
	
	@Autowired
	public AttendanceController(CRUDService<AttendanceVO> service) {
		super(service);
	}
	
	
	@PostMapping("/attendance")
	public ResponseEntity<JSONResponse<?>> attendance(@RequestBody AttendanceBulkVO attendence) {
		return attendanceService.storeAttendence(attendence);
	} 

}
