package org.api.model.jpa.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.core.model.entity.BaseEntity;

@Entity
@Table(name="locationmapping")
public class LocationMappingEntity extends BaseEntity{

	@Column
	private String name;

	@OneToMany(mappedBy="locationMapping")
	private Collection<LocationMappingDataEntity> mappingData ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<LocationMappingDataEntity> getMappingData() {
		return mappingData;
	}

	public void setMappingData(Collection<LocationMappingDataEntity> mappingData) {
		this.mappingData = mappingData;
	}

	
	
}
