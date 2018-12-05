package org.api.services.impl;

import org.api.vo.LocationMappingDataVO;
import org.api.vo.LocationMappingVO;
import org.core.service.CRUDService;
import org.core.view.JSONResponse;
import org.springframework.http.ResponseEntity;

public interface LocationService extends CRUDService<LocationMappingVO>{
	public ResponseEntity<JSONResponse<?>> search(String queryString);
	public ResponseEntity<JSONResponse<?>> listTehsils();
	public ResponseEntity<JSONResponse<?>> listChiledLocationIds(long parentLocationId);
	public ResponseEntity<JSONResponse<?>> listLocations();
	public ResponseEntity<JSONResponse<?>> listDistrict();
	public ResponseEntity<JSONResponse<?>> listProvince();
	public ResponseEntity<JSONResponse<?>> listTehsil();
	public ResponseEntity<JSONResponse<?>> listArea();
	
	public ResponseEntity<JSONResponse<?>> locationbyId(long id);
	public ResponseEntity<JSONResponse<?>> listAllOnlyNames();

}
