package org.api.controllers;

import org.api.services.impl.LocationService;
import org.core.view.JSONResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
public class LocationSearchController {

	@Autowired
	private LocationService locationSearchService;
	
	@GetMapping("/search/{q}")
	public ResponseEntity<JSONResponse<?>> search(@PathVariable("q") String q) {
		return locationSearchService.search(q);
	}
	
	
	
	@GetMapping("/listTehsils")
	public ResponseEntity<JSONResponse<?>> listTehsils() {
		return locationSearchService.listTehsils();
	}
	

	@GetMapping("/listLocations")
	public ResponseEntity<JSONResponse<?>> listLocations() {
		return locationSearchService.listLocations();
	}
	
	
	
	@GetMapping("/listprovince")
	public ResponseEntity<JSONResponse<?>> listprovince() {
		return locationSearchService.listProvince();
	}
	
	@GetMapping("/listdistrict")
	public ResponseEntity<JSONResponse<?>> listdistrict() {
		return locationSearchService.listDistrict();		
	}
	
	@GetMapping("/listtehsil")
	public ResponseEntity<JSONResponse<?>> listtehsil() {
		return locationSearchService.listTehsil();
	}
	
	@GetMapping("/listarea")
	public ResponseEntity<JSONResponse<?>> listArea() {
		return locationSearchService.listArea();
	}
	
	@GetMapping("/chiledLocationIds/{parentLocationId}")
	public ResponseEntity<JSONResponse<?>> listChiledLocationIds(@PathVariable("parentLocationId") long parentLocationId) {
		return locationSearchService.listChiledLocationIds(parentLocationId);
	}
	
	
	@GetMapping("/location-branch/{id}")
	public ResponseEntity<JSONResponse<?>> locationbyID(@PathVariable("id") long id) {
		return locationSearchService.locationbyId(id);
	}
	
	

	@GetMapping("/listallonlynames")
	public ResponseEntity<JSONResponse<?>> listallonlynames() {
		return locationSearchService.listAllOnlyNames();
	}
	
}
