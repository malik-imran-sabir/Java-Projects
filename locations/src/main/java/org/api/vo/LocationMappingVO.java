package org.api.vo;

import java.util.Collection;

import org.api.model.jpa.entity.LocationMappingDataEntity;
import org.api.model.jpa.entity.LocationMappingEntity;
import org.core.vo.BaseVO;

public class LocationMappingVO extends BaseVO{

	private String name;
	private Collection<LocationMappingEntity> mappingData ;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Collection<LocationMappingEntity> getMappingData() {
		return mappingData;
	}
	
	public void setMappingData(Collection<LocationMappingEntity> mappingData) {
		this.mappingData = mappingData;
	}
	
	
}
