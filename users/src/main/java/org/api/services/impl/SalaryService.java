package org.api.services.impl;

import org.api.vo.SalaryVO;
import org.core.service.CRUDService;
import org.core.view.JSONResponse;
import org.springframework.http.ResponseEntity;

public interface SalaryService extends CRUDService<SalaryVO> {
	public ResponseEntity<JSONResponse<?>> getSalaryList();
	public ResponseEntity<JSONResponse<?>> getSalaryListbyid(String id);
	public ResponseEntity<JSONResponse<?>> saveUpdateSalary(SalaryVO salary);
}
