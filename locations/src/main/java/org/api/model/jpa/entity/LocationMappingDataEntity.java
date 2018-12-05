package org.api.model.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.core.model.entity.BaseEntity;

@Entity(name="locationmappingdata")
@Table(name="locationmappingdata")
public class LocationMappingDataEntity extends BaseEntity {

	@Column
	private String value;
	
	@Column
	private long locationMappingId;
	
	@Column
	private Long locationMappingDataId;
	
	@ManyToOne
	@JoinColumn(name="locationMappingId", insertable=false, updatable=false)
	private LocationMappingEntity locationMapping;
	

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public LocationMappingEntity getLocationMapping() {
		return locationMapping;
	}

	public void setLocationMapping(LocationMappingEntity locationMapping) {
		this.locationMapping = locationMapping;
	}

	public long getLocationMappingId() {
		return locationMappingId;
	}

	public void setLocationMappingId(long locationMappingId) {
		this.locationMappingId = locationMappingId;
	}

	public Long getLocationMappingDataId() {
		return locationMappingDataId;
	}

	public void setLocationMappingDataId(Long locationMappingDataId) {
		this.locationMappingDataId = locationMappingDataId;
	}
	
}
