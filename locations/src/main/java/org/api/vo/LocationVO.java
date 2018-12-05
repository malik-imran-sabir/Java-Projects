package org.api.vo;

import java.util.Collection;

import org.api.model.jpa.entity.LocationMappingDataEntity;
import org.core.vo.BaseVO;

public class LocationVO extends BaseVO{

	private String name;
	private long id;
	private Collection<LocationVO> locationMapping ;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<LocationVO> getLocationMapping() {
		return locationMapping;
	}
	public void setLocationMapping(Collection<LocationVO> locationMapping) {
		this.locationMapping = locationMapping;
	}
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
