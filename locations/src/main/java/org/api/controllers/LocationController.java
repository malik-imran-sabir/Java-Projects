package org.api.controllers;

import org.api.vo.LocationMappingVO;
import org.core.service.CRUDService;
import org.core.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationController extends BaseController<LocationMappingVO>{
	
	@Autowired
	public LocationController(CRUDService<LocationMappingVO> service) {
		super(service);
	}
	
	
}
