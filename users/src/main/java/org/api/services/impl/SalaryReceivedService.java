package org.api.services.impl;

import org.api.vo.SalaryReceivedVO;
import org.core.service.CRUDService;
import org.core.view.JSONResponse;
import org.springframework.http.ResponseEntity;

public interface SalaryReceivedService extends CRUDService<SalaryReceivedVO> {
	public ResponseEntity<JSONResponse<?>> getSalaryReceivedList();
	public ResponseEntity<JSONResponse<?>> saveUpdateSalaryReceived(SalaryReceivedVO salaryreceived);
	public ResponseEntity<JSONResponse<?>> getSalaryById(String id);
}
