package org.api.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.api.model.jpa.dao.JPALocationDataDAO;
import org.api.model.jpa.entity.LocationMappingDataEntity;
import org.api.model.jpa.entity.LocationMappingEntity;
import org.api.vo.LocationMappingDataVO;

import org.core.model.dao.BaseDAO;
import org.core.model.entity.BaseEntity;
import org.core.service.CRUDServiceImpl;
import org.core.util.BeanUtils;
import org.core.util.DateUtils;
import org.core.util.JsonUtil;
import org.core.view.JSONResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("UserTypeService")
public class LocationDataServiceImpl extends CRUDServiceImpl<LocationMappingDataEntity, LocationMappingDataVO>implements LocationDataService{
	
	@Autowired
	private JPALocationDataDAO LocationData;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	/** The util. */
	
	public LocationDataServiceImpl(BaseDAO<LocationMappingDataEntity, Serializable> dao) {
		super(dao);
	}

	@Override
	public <ENTITY extends BaseEntity> ENTITY getDeepCopiedEntity(LocationMappingDataVO source) throws Throwable {
		return (ENTITY) BeanUtils.shallowCopy(source, LocationMappingDataEntity.class);
		
	}

	@Override
	public <ENTITY extends BaseEntity> LocationMappingDataVO getDeepCopiedVO(ENTITY source) throws Throwable {
		return BeanUtils.shallowCopy(source, LocationMappingDataVO.class);
	}

	@Override
	public ResponseEntity<JSONResponse<?>> findLocationMappingDataByLocationMappingId(long id) {
	
	/*	String sql = "SELECT value,id FROM `locationmappingdata` WHERE locationMappingId = :q1 ";
		EntityManager enityManager = entityManagerFactory.createEntityManager();
		Query query = (Query) enityManager.createNativeQuery(sql);
		query.setParameter("q1", id );
		Collection<LocationMappingDataEntity> records = query.getResultList();*/
		Collection<?> locations = LocationData.findByLocationMappingId(id);
		Collection<LocationMappingDataVO> locationData =  new ArrayList<LocationMappingDataVO>();
		locations.forEach(location-> {
			
			try {
				LocationMappingDataVO locationEnitity = BeanUtils.shallowCopy(location, LocationMappingDataVO.class);
				locationData.add(locationEnitity);
		
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		return JsonUtil.convertIntoJson(locationData);
		
		//List<LocationMappingDataEntity> listLocations =(List<LocationMappingDataEntity>) LocationData.findByLocationMappingId(id);
		//return util.convertIntoJson(listLocations);
	}

	@Override
	public LocationMappingDataEntity saveAnswers(LocationMappingDataVO LocationMappingData) {
			// TODO Auto-generated method stub
			Date currentTime = DateUtils.getCurrentDateTime();
			
			LocationMappingDataEntity authorityEntity = new LocationMappingDataEntity(); 
			
			authorityEntity.setCreatedOn(currentTime);
			authorityEntity.setLastUpdatedOn(currentTime);
			authorityEntity.setStatus("A");
			
			authorityEntity.setLocationMappingDataId((long)LocationMappingData.getLocationMappingDataId());
			authorityEntity.setLocationMappingId((long)LocationMappingData.getLocationMappingId());
			authorityEntity.setValue(LocationMappingData.getValue());
			
			return LocationData.save(authorityEntity);
	}
}
