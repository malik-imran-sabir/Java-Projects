package org.api.vo;


import java.util.Collection;

import org.api.model.jpa.entity.LocationMappingDataEntity;
import org.core.vo.BaseVO;

public class LocationMappingDataVO extends BaseVO{

	//private String name;
	private String value;
	
	private long locationMappingId;
	
	private long locationMappingDataId;
	
	private Collection<LocationMappingDataEntity> mappingData ;
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	/*public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}*/
	
	public Collection<LocationMappingDataEntity> getMappingData() {
		return mappingData;
	}
	public void setMappingData(Collection<LocationMappingDataEntity> mappingData) {
		this.mappingData = mappingData;
	}

	public long getLocationMappingDataId() {
		return locationMappingDataId;
	}

	public void setLocationMappingDataId(long locationMappingDataId) {
		this.locationMappingDataId = locationMappingDataId;
	}

	public long getLocationMappingId() {
		return locationMappingId;
	}

	public void setLocationMappingId(long locationMappingId) {
		this.locationMappingId = locationMappingId;
	}

	
}
