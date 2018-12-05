package org.api.controllers;

import org.api.vo.UserTypeVO;
import org.core.service.CRUDService;
import org.core.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/type")
public class UserTypeController extends BaseController<UserTypeVO>{

	@Autowired
	public UserTypeController(CRUDService<UserTypeVO> service) {
		super(service);
	}

}
