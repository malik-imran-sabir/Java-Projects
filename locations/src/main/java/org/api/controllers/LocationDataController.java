package org.api.controllers;

import org.api.model.jpa.entity.LocationMappingDataEntity;
import org.api.services.impl.LocationDataService;
import org.api.vo.LocationMappingDataVO;
import org.core.service.CRUDService;
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
@RequestMapping("/locationData")
public class LocationDataController extends BaseController<LocationMappingDataVO>{

	@Autowired
	public LocationDataController(CRUDService<LocationMappingDataVO> service) {
		super(service);
	}

	@Autowired
	private LocationDataService locationDataService;
	
	
	@GetMapping("/mappingData/{id}")
	public ResponseEntity<JSONResponse<?>> locationsByMappingId(@PathVariable("id") long id) {
		return locationDataService.findLocationMappingDataByLocationMappingId(id);
	
	}
	
	@PostMapping("/save-location")
	public LocationMappingDataEntity savelocation(@RequestBody LocationMappingDataVO LocationMappingData){
		return locationDataService.saveAnswers(LocationMappingData);
	}
}
