package org.api.services.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.api.model.jpa.dao.JPASalaryDAO;
import org.api.model.jpa.entity.SalaryEntity;
import org.api.model.jpa.entity.UserEntity;
import org.api.vo.ExamDataVO;
import org.api.vo.SalaryVO;
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

@Service("SalaryService")
public class SalaryServiceImpl  extends CRUDServiceImpl<SalaryEntity,SalaryVO> implements SalaryService {
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	private JPASalaryDAO salaryDAO;

	public SalaryServiceImpl(BaseDAO<SalaryEntity, Serializable> dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public <ENTITY extends BaseEntity> ENTITY getDeepCopiedEntity(SalaryVO source) throws Throwable {
		// TODO Auto-generated method stub
		return (ENTITY)BeanUtils.shallowCopy(source, SalaryEntity.class);
	}

	@Override
	public <ENTITY extends BaseEntity> SalaryVO getDeepCopiedVO(ENTITY source) throws Throwable {
		// TODO Auto-generated method stub
		return BeanUtils.shallowCopy(source, SalaryVO.class);
	}

	@Override
	public ResponseEntity<JSONResponse<?>> getSalaryList() {
		// TODO Auto-generated method stub
				String sql = " select id,salarydate from salary order by id desc ";
				
				EntityManager enityManager = entityManagerFactory.createEntityManager();

				Query query = (Query) enityManager.createNativeQuery(sql);
				//query.setParameter("q1", teacherId);

				List<Object[]> attendanceRecords =  query.getResultList();
				List<SalaryVO> listObject = new ArrayList<>();

				attendanceRecords.forEach(datalist -> {
					
					SalaryVO obj = new SalaryVO();
					
					obj.setId((int)datalist[0]);
					obj.setSalarydate((java.sql.Date)datalist[1]);
					
					listObject.add(obj);		
				});

				return JsonUtil.convertIntoJson(listObject);
	}

	@Override
	public ResponseEntity<JSONResponse<?>> saveUpdateSalary(SalaryVO salary) {
		// TODO Auto-generated method stub
		Date currentTime = DateUtils.getCurrentDateTime();
		
		try {
			SalaryEntity salaryEntity  = BeanUtils.shallowCopy(salary, SalaryEntity.class);
			salaryEntity.setCreatedOn(currentTime);
			salaryEntity.setLastUpdatedOn(currentTime);
			salaryEntity.setCreatedBy(salary.getCreatedBy());
			salaryEntity.setSalarydate((java.sql.Date)salary.getSalarydate());
			salaryDAO.save(salaryEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 		return null;
	}

	@Override
	public ResponseEntity<JSONResponse<?>> getSalaryListbyid(String id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sql = "  select " + 
				"   s.id, " + 
				"		s.salarydate, " + 
				"    r.status, " + 
				"    s.createdOn " + 
				" from salary s" + 
				" left join salary_received r on r.salaryId = s.id " + 
				" and userId = :q1 ";
		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		query.setParameter("q1", id);

		List<Object[]> attendanceRecords =  query.getResultList();
		List<SalaryVO> listObject = new ArrayList<>();

		attendanceRecords.forEach(datalist -> {
			
			SalaryVO obj = new SalaryVO();
			
			obj.setId((int)datalist[0]);
			obj.setSalarydate((java.sql.Date)datalist[1]);
			
			obj.setStatus((String)datalist[2]);
			//obj.setCreatedOn((java.sql.Date)datalist[3]);
			
			listObject.add(obj);		
			
		});

		return JsonUtil.convertIntoJson(listObject);
	}

}
