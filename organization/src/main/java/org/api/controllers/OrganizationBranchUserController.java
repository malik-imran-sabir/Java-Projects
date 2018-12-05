package org.api.controllers;

import org.api.services.impl.OrganizationBranchService;
import org.api.vo.OrganizationBranchUserVO;
import org.api.vo.OrganizationVO;
import org.core.service.CRUDService;
import org.core.view.JSONResponse;
import org.core.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/org/branch/user")
public class OrganizationBranchUserController extends BaseController<OrganizationBranchUserVO>{
	
	@Autowired
	private OrganizationBranchService organizationBranchService;
	
	@Autowired
	public OrganizationBranchUserController(CRUDService<OrganizationBranchUserVO> service) {
		super(service);
	}
	
	@GetMapping("/nigrans/{id}")
	public ResponseEntity<JSONResponse<?>> nigrans(@PathVariable("id") Long id) {
		return organizationBranchService.getNigrans(id);
	}

}
