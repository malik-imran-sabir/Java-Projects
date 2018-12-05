package org.api.services.impl;

import org.api.vo.UserTypeVO;
import org.core.service.CRUDService;
import org.core.view.JSONResponse;
import org.springframework.http.ResponseEntity;

public interface UserTypeService extends CRUDService<UserTypeVO>{
	public ResponseEntity<JSONResponse<?>> userTypeById(long typeId);
}
