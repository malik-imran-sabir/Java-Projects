package org.api.model.jpa.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.api.model.jpa.entity.LocationMappingEntity;
import org.api.vo.LocationMappingVO;
import org.core.model.dao.BaseDAO;
import org.core.model.entity.BaseEntity;
import org.core.service.CRUDServiceImpl;
import org.springframework.stereotype.Service;
@Service("testService")
public class CustomLocationDAO {

	@PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
	
	public   Collection<?> getlocations(String queryString) {

		String sql = "SELECT " + 
				"l1.value AS country" + 
				",l2.value AS province" + 
				",l3.value AS district" + 
				",l4.value AS Tehsil " +
				",l4.id locationId " + 
			"FROM " + 
			"locationmappingdata l1 " +
				"LEFT JOIN locationmappingdata l2 ON (l1.id = l2.locationmappingdataId) " + 
				"LEFT JOIN locationmappingdata l3 ON (l2.id = l3.locationmappingdataId) " + 
				"LEFT JOIN locationmappingdata l4 ON (l3.id = l4.locationMappingDataId) " + 
			"WHERE " + 
				"l1.locationMappingDataId IS NULL "+
			"AND l4.value LIKE :q1 ";
		
		 EntityManager enityManager = entityManagerFactory.createEntityManager();
		
		 Query query = ( Query) enityManager.createNativeQuery(sql);
		 query.setParameter("q1", "%"+queryString+"%");
		 
		 return query.getResultList();
	}
	
}
