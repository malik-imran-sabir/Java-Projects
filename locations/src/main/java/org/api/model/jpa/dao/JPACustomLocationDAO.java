package org.api.model.jpa.dao;

import java.util.Collection;

import org.api.model.jpa.entity.LocationMappingDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JPACustomLocationDAO extends JpaRepository<LocationMappingDataEntity, Long> {
	
	@Query(value = "SELECT lmd.value as value FROM locationmappingdata lmd where lmd.value like %:q%", nativeQuery = true) 
	//public Collection<LocationMappingDataEntity>  findLocationByValue();
	public Collection<LocationMappingDataEntity>  findLocationByValue(@Param("q") String query);
 }