package org.api.services.impl;

import org.api.vo.AttendanceBulkVO;
import org.api.vo.AttendanceVO;
import org.core.service.CRUDService;
import org.core.view.JSONResponse;
import org.springframework.http.ResponseEntity;

public interface AttendanceService extends CRUDService<AttendanceVO>{
	public ResponseEntity<JSONResponse<?>> storeAttendence(AttendanceBulkVO attendanceBulk);
}
