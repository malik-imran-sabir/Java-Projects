package org.api.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.api.model.jpa.dao.JPASalaryReceivedDAO;
import org.api.model.jpa.entity.SalaryEntity;
import org.api.model.jpa.entity.SalaryReceivedEntity;
import org.api.vo.SalaryReceivedVO;
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

@Service("SalaryReceivedService")
public class SalaryReceivedServiceImpl extends CRUDServiceImpl<SalaryReceivedEntity,SalaryReceivedVO> implements SalaryReceivedService {
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	private JPASalaryReceivedDAO salaryReceivedDAO;

	public SalaryReceivedServiceImpl(BaseDAO<SalaryReceivedEntity, Serializable> dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public <ENTITY extends BaseEntity> ENTITY getDeepCopiedEntity(SalaryReceivedVO source) throws Throwable {
		// TODO Auto-generated method stub
		return (ENTITY)BeanUtils.shallowCopy(source, SalaryReceivedEntity.class);
	}

	@Override
	public <ENTITY extends BaseEntity> SalaryReceivedVO getDeepCopiedVO(ENTITY source) throws Throwable {
		// TODO Auto-generated method stub
		return BeanUtils.shallowCopy(source, SalaryReceivedVO.class);
	}

	@Override
	public ResponseEntity<JSONResponse<?>> getSalaryReceivedList() {
		// TODO Auto-generated method stub
		String sql = " select sr.id,sr.receivedOn,sr.userId,u.name, sr.salaryId from salary_received sr " + 
				" left join user u on u.id = sr.userId " + 
				" left join salary s on s.id = sr.salaryId ";
		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		//query.setParameter("q1", teacherId);

		List<Object[]> attendanceRecords =  query.getResultList();
		List<SalaryReceivedVO> listObject = new ArrayList<>();

		attendanceRecords.forEach(datalist -> {
			
			SalaryReceivedVO obj = new SalaryReceivedVO();
			
			obj.setId((int)datalist[0]);
			obj.setReceivedOn((java.sql.Date)datalist[1]);
			obj.setUserId((int)datalist[2]);
			obj.setName((String)datalist[3]);
			obj.setSalaryId((int)datalist[4]);
			
			listObject.add(obj);		
		});

		return JsonUtil.convertIntoJson(listObject);
	}
	
	
	@Override
	public ResponseEntity<JSONResponse<?>> getSalaryById(String id) {
		// TODO Auto-generated method stub
		String sql = " select sr.id,sr.receivedOn,sr.userId,u.name, sr.salaryId from salary_received sr " + 
				" left join user u on u.id = sr.userId " + 
				" left join salary s on s.id = sr.salaryId"
				+ " where sr.salaryId = :q1 ";
		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		query.setParameter("q1", id);

		List<Object[]> attendanceRecords =  query.getResultList();
		List<SalaryReceivedVO> listObject = new ArrayList<>();

		attendanceRecords.forEach(datalist -> {
			
			SalaryReceivedVO obj = new SalaryReceivedVO();
			
			obj.setId((int)datalist[0]);
			obj.setReceivedOn((java.sql.Date)datalist[1]);
			obj.setUserId((int)datalist[2]);
			obj.setName((String)datalist[3]);
			obj.setSalaryId((int)datalist[4]);
			
			listObject.add(obj);		
		});

		return JsonUtil.convertIntoJson(listObject);
	}

	@Override
	public ResponseEntity<JSONResponse<?>> saveUpdateSalaryReceived(SalaryReceivedVO salary) {
		// TODO Auto-generated method stub
		Date currentTime = DateUtils.getCurrentDateTime();
		
				try {
					SalaryReceivedEntity salaryEntity  = BeanUtils.shallowCopy(salary, SalaryReceivedEntity.class);
					salaryEntity.setCreatedOn(currentTime);
					salaryEntity.setLastUpdatedOn(currentTime);
					salaryReceivedDAO.save(salaryEntity);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return JsonUtil.convertSingleEntityToJson(salary);
				//return JsonUtil.convertIntoJson(salaryEntity);;
	}

}
