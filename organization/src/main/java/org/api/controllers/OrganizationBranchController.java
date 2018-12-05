package org.api.controllers;

import java.io.File;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.api.model.jpa.dao.JPAOrganizationBranchDAO;
import org.api.model.jpa.entity.OrganizationBranchEntity;
import org.api.services.impl.OrganizationBranchService;
import org.api.vo.OrganizationBranchVO;
import org.core.service.CRUDService;
import org.core.util.FileUploadUtils;
import org.core.util.JsonUtil;
import org.core.view.JSONResponse;
import org.core.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/org/branch")
public class OrganizationBranchController extends BaseController<OrganizationBranchVO> {
	@Autowired
	private OrganizationBranchService branchService;
	
	@Autowired
	private JPAOrganizationBranchDAO branchesRepo;

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	public OrganizationBranchController(CRUDService<OrganizationBranchVO> service) {
		super(service);
	}

	@PostMapping("/saveUpdate")
	public ResponseEntity<JSONResponse<?>> saveUpdate(@RequestBody OrganizationBranchVO branch,
			HttpServletRequest request) {
		String imagePath = FileUploadUtils.getBasePath(request) + File.separatorChar+FileUploadUtils.randomAlphaNumeric(10)+".jpeg";
		return branchService.saveUpdate(branch, imagePath);

	}

	@GetMapping("/all-branches")
	public ResponseEntity<JSONResponse<?>> getAll() {
		return branchService.getCustomBranchData();

	}
	
	
	@GetMapping("/list-branches-by-location/{locationIds}")
	public ResponseEntity<JSONResponse<?>> ListBranchesByLocation(@PathVariable("locationIds") List<String> locationIds) {
		try {
			return branchService.ListBranchesByLocation(locationIds);
	
		} catch (Exception e) {
			logger.error("Error=>"+e.getLocalizedMessage());
			return null;
		}

	}

}
