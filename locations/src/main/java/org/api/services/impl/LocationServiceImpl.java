package org.api.services.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.api.model.jpa.dao.JPALocationDAO;
import org.api.model.jpa.entity.LocationMappingDataEntity;
import org.api.model.jpa.entity.LocationMappingEntity;
import org.api.vo.LocationMappingDataVO;
import org.api.vo.LocationMappingVO;
import org.api.vo.LocationModel;
import org.core.model.dao.BaseDAO;
import org.core.model.entity.BaseEntity;
import org.core.service.CRUDServiceImpl;
import org.core.util.BeanUtils;
import org.core.util.DateUtils;
import org.core.util.HttpUtils;
import org.core.util.JsonUtil;
import org.core.view.JSONResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mysql.jdbc.RowData;

@Service("UserService")
public class LocationServiceImpl extends CRUDServiceImpl<LocationMappingEntity, LocationMappingVO>
		implements LocationService {

	LocationService locationService;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private JPALocationDAO locDAO;
	
	public LocationServiceImpl(BaseDAO<LocationMappingEntity, Serializable> dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public <ENTITY extends BaseEntity> ENTITY getDeepCopiedEntity(LocationMappingVO source) throws Throwable {
		return (ENTITY) BeanUtils.shallowCopy(source, LocationMappingEntity.class);
	}

	@Override
	public <ENTITY extends BaseEntity> LocationMappingVO getDeepCopiedVO(ENTITY source) throws Throwable {
		return BeanUtils.shallowCopy(source, LocationMappingVO.class);
	}

	@Override
	public ResponseEntity<JSONResponse<?>> search(String queryString) {
		String sql = "SELECT " + "l1.value AS country" + ",l2.value AS province" + ",l3.value AS district"
				+ ",l4.value AS Tehsil " + ",l4.id locationId " + "FROM " + "locationmappingdata l1 "
				+ "LEFT JOIN locationmappingdata l2 ON (l1.id = l2.locationmappingdataId) "
				+ "LEFT JOIN locationmappingdata l3 ON (l2.id = l3.locationmappingdataId) "
				+ "LEFT JOIN locationmappingdata l4 ON (l3.id = l4.locationMappingDataId) " + "WHERE "
				+ "l1.locationMappingDataId IS NULL "
				+ "AND l4.value LIKE :q1 "
				+ "OR l4.value LIKE :q2 ";
		

		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		query.setParameter("q1", "%" + queryString + "%");
		query.setParameter("q2", "%" + queryString + "%");

		Collection<?> records = query.getResultList();

		return JsonUtil.convertIntoJson(records);
	}

	@Override
	public ResponseEntity<JSONResponse<?>> listTehsils() {
		String sql = " select * from (SELECT " + "l4.id id " + ",l4.value AS Tehsil " + "FROM " + "locationmappingdata l1 "
				+ "LEFT JOIN locationmappingdata l2 ON (l1.id = l2.locationmappingdataId) "
				+ "LEFT JOIN locationmappingdata l3 ON (l2.id = l3.locationmappingdataId) "
				+ "LEFT JOIN locationmappingdata l4 ON (l3.id = l4.locationMappingDataId) " + "WHERE "
				+ "l1.locationMappingDataId IS NOT NULL " + "AND l4.value IS NOT NULL "
						+ "UNION " +
				"SELECT l5.id AS  `id`, l5.value AS  `Tehsil` " + "FROM " + "locationmappingdata l1 "
					+ "LEFT JOIN locationmappingdata l2 ON (l1.id = l2.locationmappingdataId) "
					+ "LEFT JOIN locationmappingdata l3 ON (l2.id = l3.locationmappingdataId) "
					+ "LEFT JOIN locationmappingdata l4 ON (l3.id = l4.locationMappingDataId) "
					+ "LEFT JOIN locationmappingdata l5 ON (l4.id = l5.locationMappingDataId) WHERE "
					+ "l1.locationMappingDataId IS NULL " + "AND l5.value IS NOT NULL ) t order by value ";

		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);

		List<Object[]> records = query.getResultList();
		List<LocationModel> totalList=new ArrayList<>();
		
		records.forEach(item -> 
		{
			LocationModel model=new LocationModel((BigInteger)item[0],  (String)item[1]);
			totalList.add(model);
		});

		return JsonUtil.convertIntoJson(totalList);
	}
	
	@Override
	public ResponseEntity<JSONResponse<?>> listLocations() {
		
		String sql = "select * from ( select l3.id,concat(l1.value, '<-',l2.value ,' <- ', l3.value ) area " + 
				"				from locationmappingdata l3" + 
				"				 left join locationmappingdata l2 on l2.id = l3.locationMappingDataId  " + 
				"				 left join locationmappingdata l1 on l1.id = l2.locationMappingDataId  " + 
				"				 where l3.locationMappingId =3 " + 
				" union all " + 
				"select l4.id,concat(l1.value, '<-',l2.value ,' <- ', l3.value ,' <- ', l4.value) area " + 
				"				from locationmappingdata l4\r\n" + 
				"				 left join locationmappingdata l3 on l3.id = l4.locationMappingDataId  " + 
				"				 left join locationmappingdata l2 on l2.id = l3.locationMappingDataId  " + 
				"				 left join locationmappingdata l1 on l1.id = l2.locationMappingDataId  " + 
				"				 where l4.locationMappingId =4" + 
				" union all " + 
				" select l5.id,concat(l1.value, '<-',l2.value ,' <- ', l3.value ,' <- ', l4.value,' <- ', l5.value) area from locationmappingdata l5 " + 
				"				 left join locationmappingdata l4 on l4.id = l5.locationMappingDataId " + 
				"				 left join locationmappingdata l3 on l3.id = l4.locationMappingDataId " + 
				"				 left join locationmappingdata l2 on l2.id = l3.locationMappingDataId " + 
				"				 left join locationmappingdata l1 on l1.id = l2.locationMappingDataId " + 
				"				 where l5.locationMappingId =5 ) t " + 
				"order by area ";

		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);

		List<Object[]> records = query.getResultList();
		List<LocationModel> totalList=new ArrayList<>();
		
		records.forEach(item -> 
		{
			LocationModel model=new LocationModel((BigInteger)item[0],  (String)item[1]);
			totalList.add(model);
		});

		return JsonUtil.convertIntoJson(totalList);
	}
	
	@Override
	public ResponseEntity<JSONResponse<?>> listProvince() {
		
		String sql = " select id,value area from locationmappingdata   " + 
				"				 where locationMappingId =2 order by value ";

		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);

		List<Object[]> records = query.getResultList();
		List<LocationModel> totalList=new ArrayList<>();
		
		records.forEach(item -> 
		{
			LocationModel model=new LocationModel((BigInteger)item[0],  (String)item[1]);
			totalList.add(model);
		});

		return JsonUtil.convertIntoJson(totalList);
	}
	
	
	@Override
	public ResponseEntity<JSONResponse<?>> listDistrict() {
		
		String sql = " select id,value area from locationmappingdata   " + 
				"				 where locationMappingId =3 order by value ";

		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);

		List<Object[]> records = query.getResultList();
		List<LocationModel> totalList=new ArrayList<>();
		
		records.forEach(item -> 
		{
			LocationModel model=new LocationModel((BigInteger)item[0],  (String)item[1]);
			totalList.add(model);
		});

		return JsonUtil.convertIntoJson(totalList);
	}
	
	
	@Override
	public ResponseEntity<JSONResponse<?>> listTehsil() {
		
		String sql = " select id,value area from locationmappingdata  " + 
				"			 where locationMappingId =4 order by value ";

		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);

		List<Object[]> records = query.getResultList();
		List<LocationModel> totalList=new ArrayList<>();
		
		records.forEach(item -> 
		{
			LocationModel model=new LocationModel((BigInteger)item[0],  (String)item[1]);
			totalList.add(model);
		});

		return JsonUtil.convertIntoJson(totalList);
	}

	
	@Override
	public ResponseEntity<JSONResponse<?>> listArea() {
		
		String sql = " select l5.id,concat(l1.value, '<-',l2.value ,' <- ', l3.value ,' <- ', l4.value,' <- ', l5.value) area from locationmappingdata l5 " + 
				" left join locationmappingdata l4 on l4.id = l5.locationMappingDataId " + 
				" left join locationmappingdata l3 on l3.id = l4.locationMappingDataId " + 
				" left join locationmappingdata l2 on l2.id = l3.locationMappingDataId " + 
				" left join locationmappingdata l1 on l1.id = l2.locationMappingDataId " + 
				" where l5.locationMappingId =5 "
				+ " order by l1.value,l2.value,l3.value,l4.value,l5.value ";

		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);

		List<Object[]> records = query.getResultList();
		List<LocationModel> totalList=new ArrayList<>();
		
		records.forEach(item -> 
		{
			LocationModel model=new LocationModel((BigInteger)item[0],  (String)item[1]);
			totalList.add(model);
		});

		return JsonUtil.convertIntoJson(totalList);
	}
	@Override
	public ResponseEntity<JSONResponse<?>> listChiledLocationIds(long parentLocationId) {
		
		String sql = "SELECT l3.id " + 
				"FROM locationmappingdata l1 " + 
					"JOIN locationmappingdata l2 ON l1.id = l2.locationMappingDataId " + 
					"JOIN locationmappingdata l3 ON l2.id = l3.locationMappingDataId " + 
					"JOIN locationmappingdata l4 ON l3.id = l4.locationMappingDataId " + 
				"WHERE l1.id = :q1 " + 
				"UNION " + 
				"SELECT l4.id " + 
				"FROM locationmappingdata l1 " + 
					"JOIN locationmappingdata l2 ON l1.id = l2.locationMappingDataId " + 
					"JOIN locationmappingdata l3 ON l2.id = l3.locationMappingDataId " + 
					"JOIN locationmappingdata l4 ON l3.id = l4.locationMappingDataId " + 
				"WHERE l1.id = :q2 "+
				"UNION " + 
				"SELECT l4.id " + 
				"FROM locationmappingdata l1 " + 
					"JOIN locationmappingdata l2 ON l1.id = l2.locationMappingDataId " + 
					"JOIN locationmappingdata l3 ON l2.id = l3.locationMappingDataId " + 
					"JOIN locationmappingdata l4 ON l3.id = l4.locationMappingDataId " + 
				"WHERE l3.id = :q3";
		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		query.setParameter("q1", parentLocationId );
		query.setParameter("q2", parentLocationId );
		query.setParameter("q3", parentLocationId );
		
		List<Object[]> records = query.getResultList();
		return JsonUtil.convertIntoJson(records);
	}
	
	
	@Override
	public ResponseEntity<JSONResponse<?>> locationbyId(long id) {
		
		String sql = "select id,value from locationmappingdata where id=:q1  ";
		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		query.setParameter("q1", id );
		
		
		List<Object[]> records = query.getResultList();
		return JsonUtil.convertIntoJson(records);
	}

	@Override
	public ResponseEntity<JSONResponse<?>> listAllOnlyNames() {
		String sql = "select id,value from locationmappingdata ";

		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);

		List<Object[]> records = query.getResultList();
		List<LocationModel> totalList=new ArrayList<>();
		
		records.forEach(item -> 
		{
			LocationModel model=new LocationModel((BigInteger)item[0],  (String)item[1]);
			totalList.add(model);
		});

		return JsonUtil.convertIntoJson(totalList);
	}
	
}
