package org.api.services.impl;

import org.api.model.jpa.entity.LocationMappingDataEntity;
import org.api.vo.LocationMappingDataVO;
import org.core.service.CRUDService;
import org.core.view.JSONResponse;
import org.springframework.http.ResponseEntity;

public interface LocationDataService extends CRUDService<LocationMappingDataVO>{
	public  ResponseEntity<JSONResponse<?>> findLocationMappingDataByLocationMappingId (long id);
	
	public LocationMappingDataEntity saveAnswers(LocationMappingDataVO LocationMappingData);
}
