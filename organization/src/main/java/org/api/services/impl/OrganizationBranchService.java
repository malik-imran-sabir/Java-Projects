package org.api.services.impl;

import java.util.List;

import org.api.vo.OrganizationBranchVO;
import org.core.service.CRUDService;
import org.core.view.JSONResponse;
import org.springframework.http.ResponseEntity;

public interface OrganizationBranchService extends CRUDService<OrganizationBranchVO>{

	public ResponseEntity<JSONResponse<?>> getCustomBranchData();
	public ResponseEntity<JSONResponse<?>> getNigrans(Long id);
	public ResponseEntity<JSONResponse<?>> saveUpdate(OrganizationBranchVO branch, String imagePath) ;
	public ResponseEntity<JSONResponse<?>> ListBranchesByLocation(List<String> locationIds) throws Exception;
}
