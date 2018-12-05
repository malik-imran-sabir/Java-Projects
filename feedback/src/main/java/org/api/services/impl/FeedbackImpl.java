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

import org.api.model.jpa.dao.JPAQuestionsAnswersDAO;
import org.api.model.jpa.entity.QuestionsAnswersEntity;
import org.api.vo.QuestionsAnswersVO;
import org.api.vo.QuestionsAnswersVOList;
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

@Service("Feedback")
public class FeedbackImpl extends CRUDServiceImpl<QuestionsAnswersEntity, QuestionsAnswersVO>
		implements FeedbackService {
	
	/** The entity manager factory. */
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private	JPAQuestionsAnswersDAO questionsAnswersDAO;
	
	public FeedbackImpl(BaseDAO<QuestionsAnswersEntity, Serializable> dao) {
		super(dao);
	}

	@Override
	public <ENTITY extends BaseEntity> ENTITY getDeepCopiedEntity(QuestionsAnswersVO source) throws Throwable {
		return (ENTITY) BeanUtils.shallowCopy(source, QuestionsAnswersEntity.class);

	}

	@Override
	public <ENTITY extends BaseEntity> QuestionsAnswersVO getDeepCopiedVO(ENTITY source) throws Throwable {
		return BeanUtils.shallowCopy(source, QuestionsAnswersVO.class);
	}

	@Override
	public QuestionsAnswersEntity saveAnswers(QuestionsAnswersVOList QuestionsAnswers) {
		QuestionsAnswersEntity answersEnity = null;
		for(QuestionsAnswersVO answer :QuestionsAnswers.getAnswers()) {
			try {
				QuestionsAnswersEntity entity = BeanUtils.shallowCopy(answer, QuestionsAnswersEntity.class);
				entity.setCreatedOn(new Date());
				entity.setLastUpdatedOn(new Date());
				answersEnity = null;//questionsAnswersDAO.save(entity);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return answersEnity;
	}
	
	
	@Override
	public ResponseEntity<JSONResponse<?>> listAnswers() {

		String sql = " SELECT uniquekeystamp,createdon,userId,madarsaId FROM question_answers " + 
				"group by uniquekeystamp,createdon order by id desc ";
		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		//query.setParameter("q1", teacherId);

		List<Object[]> attendanceRecords =  query.getResultList();
		List<QuestionsAnswersVO> attendanceList = new ArrayList<>();	

		attendanceRecords.forEach(datalist -> {
			
			QuestionsAnswersVO obj = new QuestionsAnswersVO();
			
			obj.setUniquekeystamp((String)datalist[0]);
			obj.setVisitDate((Date)datalist[1]);
			obj.setMadarsaId((int)datalist[3]);
			//obj.setUserId((long)datalist[2]);
			
			attendanceList.add(obj);		
		});

		return JsonUtil.convertIntoJson(attendanceList);
	}
	
	
	@Override
	public ResponseEntity<JSONResponse<?>> feedbackAnswer(String id) {

		String sql = " select an.uniquekeystamp, an.visitDate,q.id, an.answer, q.question que "
				+ " from `question_answers` an" + 
				" left join questions q  on q.`id` = an.`questionId` " + 
				" where an.uniquekeystamp = :q1 ";
		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		query.setParameter("q1", id);

		List<Object[]> attendanceRecords =  query.getResultList();
		List<QuestionsAnswersVO> attendanceList = new ArrayList<>();

		attendanceRecords.forEach(datalist -> {
			
			QuestionsAnswersVO obj = new QuestionsAnswersVO();
			
			obj.setUniquekeystamp((String)datalist[0]);
			obj.setVisitDate((Date)datalist[1]);
			//obj.setId((long)datalist[2]);
			obj.setAnswer((String)datalist[3]);
			obj.setQuestion((String)datalist[4]);
			
			attendanceList.add(obj);		
		});

		return JsonUtil.convertIntoJson(attendanceList);
	}
	

}
