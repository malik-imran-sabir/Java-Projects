package org.api.services.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.api.model.jpa.dao.JPAOrganizationNotificationDAO;
import org.api.model.jpa.entity.OrganizationNotificationsEntity;
import org.api.vo.OrganizationNotificationListVO;
import org.api.vo.OrganizationNotificationsVO;
import org.core.model.dao.BaseDAO;
import org.core.model.entity.BaseEntity;
import org.core.service.CRUDServiceImpl;
import org.core.util.BeanUtils;
import org.core.util.JsonUtil;
import org.core.view.JSONResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service("OrganizationNotificationService")
public class OrganizationNotificationServiceImpl  extends CRUDServiceImpl<OrganizationNotificationsEntity, OrganizationNotificationsVO> implements OrganizationNotificationService {

	@Autowired
	private	JPAOrganizationNotificationDAO examDataDAO;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	public OrganizationNotificationServiceImpl(BaseDAO<OrganizationNotificationsEntity, Serializable> dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public <ENTITY extends BaseEntity> ENTITY getDeepCopiedEntity(OrganizationNotificationsVO source) throws Throwable {
		// TODO Auto-generated method stub
		return (ENTITY) BeanUtils.shallowCopy(source, OrganizationNotificationsEntity.class);
	}

	@Override
	public <ENTITY extends BaseEntity> OrganizationNotificationsVO getDeepCopiedVO(ENTITY source) throws Throwable {
		// TODO Auto-generated method stub
		return BeanUtils.shallowCopy(source, OrganizationNotificationsVO.class);
	}

	@Override
	public ResponseEntity<JSONResponse<?>> getListNotifications() {
		// TODO Auto-generated method stub
		String sql = " select id,notification,expiredOn from   organizationnotifications  "
				+ " where expiredOn >= now()-1 "
				+ " order by id desc ";
		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		//query.setParameter("q1", username);

		try {
			
			
			List<Object[]> studentRecords = query.getResultList();
			List<OrganizationNotificationsVO> studentsList = new ArrayList<>();

			studentRecords.forEach(student -> {
				
				OrganizationNotificationsVO user = new OrganizationNotificationsVO();
				
				//user.setId((BigInteger) student[0]);
				user.setNotification((String)student[1]);
				user.setExpiredOn((Date)student[2]);
				
				studentsList.add(user);		
			});

			
			
			return JsonUtil.convertSingleEntityToJson(studentsList);

		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public OrganizationNotificationsEntity saveAnswers(OrganizationNotificationListVO examData) {
		// TODO Auto-generated method stub
		OrganizationNotificationsEntity answersEnity = null;
				for(OrganizationNotificationsVO answer : examData.getNotifications()) {
					try {
						OrganizationNotificationsEntity entity = BeanUtils.shallowCopy(answer, OrganizationNotificationsEntity.class);
						entity.setCreatedOn(new Date());
						entity.setLastUpdatedOn(new Date());
						answersEnity = null;//examDataDAO.save(entity);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				return answersEnity;
	}

	@Override
	public ResponseEntity<JSONResponse<?>> getdatacounts() {
		
		// TODO Auto-generated method stub
				String sql = " select count(*) OrganizationBranch  from organizationbranch ";
				
				EntityManager enityManager = entityManagerFactory.createEntityManager();

				Query query = (Query) enityManager.createNativeQuery(sql);
				//query.setParameter("q1", username);

				try {
					
					ArrayList<String> list = new ArrayList<String>();
					
					Object studentRecords = query.getSingleResult();
					
				
					
					list.add(studentRecords.toString());
					
			
					
					
					return JsonUtil.convertIntoJson(list);

				} catch (NoResultException e) {
					return null;
				}
	}

	@Override
	public ResponseEntity<JSONResponse<?>> alreadyexist(String value) {
		// TODO Auto-generated method stub
		String sql = " select count(*) TotalValue  from organizationbranch "
				+ " where name = :q1 ";
		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		query.setParameter("q1", value);

		try {
			ArrayList<String> list = new ArrayList<String>();
			
			Object studentRecords = query.getSingleResult();

			list.add(studentRecords.toString());
			
			return JsonUtil.convertIntoJson(list);

		} catch (NoResultException e) {
			return null;
		}
	}

}
