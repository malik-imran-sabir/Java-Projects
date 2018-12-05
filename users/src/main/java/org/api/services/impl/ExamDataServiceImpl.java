package org.api.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.api.model.jpa.dao.JPAExamDataDAO;
import org.api.model.jpa.dao.JPAQuestionsAnswersDAO;
import org.api.model.jpa.entity.ExamDataEntity;
import org.api.model.jpa.entity.QuestionsAnswersEntity;
import org.api.vo.ExamDataVO;
import org.api.vo.ExamDataVOList;
import org.api.vo.QuestionsAnswersVO;
import org.api.vo.QuestionsAnswersVOList;
import org.core.model.dao.BaseDAO;
import org.core.model.entity.BaseEntity;
import org.core.service.CRUDServiceImpl;
import org.core.util.BeanUtils;
import org.core.util.JsonUtil;
import org.core.view.JSONResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * The Class ExamDataServiceImpl.
 */
@Service("ExamDataService")
public class ExamDataServiceImpl extends CRUDServiceImpl<ExamDataEntity, ExamDataVO> implements ExamDataService {
	
	@Autowired
	private	JPAExamDataDAO examDataDAO;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	private	JPAQuestionsAnswersDAO questionsAnswersDAO;
	
	public ExamDataServiceImpl(BaseDAO<ExamDataEntity, Serializable> dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public <ENTITY extends BaseEntity> ENTITY getDeepCopiedEntity(ExamDataVO source) throws Throwable {
		// TODO Auto-generated method stub
		return (ENTITY)BeanUtils.shallowCopy(source, ExamDataEntity.class);
	}
	

	@Override
	public <ENTITY extends BaseEntity> ExamDataVO getDeepCopiedVO(ENTITY source) throws Throwable {
		// TODO Auto-generated method stub
		return BeanUtils.shallowCopy(source, ExamDataVO.class);
	}

	@Override
	public ResponseEntity<JSONResponse<?>> getExamList() {
		
		// TODO Auto-generated method stub
		String sql = " select id,examtype,examyear,studentId,madarsaId,examdate,"
				+ " theoryNumbers, duaNumbers, namazNumbers, userId	, uniquekeyname from  examsdata"
				+ " order by id desc ";
		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		//query.setParameter("q1", username);

		try {
			
			List<Object[]> studentRecords = query.getResultList();
			List<ExamDataVO> studentsList = new ArrayList<>();

			studentRecords.forEach(student -> {
				
				ExamDataVO user = new ExamDataVO();
				
				//user.setId((BigInteger) student[0]);
				user.setExamtype((String)student[1]);
				user.setExamyear((int)student[2]);
				
				user.setTheoryNumbers((double)student[6]);
				user.setDuaNumbers((double)student[7]);
				user.setNamazNumbers((double)student[8]);
				
				
				
				studentsList.add(user);		
			});

			
			
			return JsonUtil.convertSingleEntityToJson(studentsList);

		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public ResponseEntity<JSONResponse<?>> getExamListbyKey(String uniquekeyname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamDataEntity saveAnswers(ExamDataVOList examData) {
		// TODO Auto-generated method stub
		ExamDataEntity answersEnity = null;
		for(ExamDataVO answer : examData.getExams()) {
			try {
				ExamDataEntity entity = BeanUtils.shallowCopy(answer, ExamDataEntity.class);
				entity.setCreatedOn(new Date());
				//entity.setExamdate(new Date());
				entity.setLastUpdatedOn(new Date());
				answersEnity = null;//examDataDAO.save(entity);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return answersEnity;
	}

	@Override
	public ResponseEntity<JSONResponse<?>> examlist() {
		// TODO Auto-generated method stub
		String sql = " SELECT uniquekeyname, examdate, examtype, createdOn,madarsaId from examsdata " + 
				"group by uniquekeyname,createdOn "
				+ " order by id desc";
		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		//query.setParameter("q1", teacherId);

		List<Object[]> attendanceRecords =  query.getResultList();
		List<ExamDataVO> attendanceList = new ArrayList<>();

		attendanceRecords.forEach(datalist -> {
			
			ExamDataVO obj = new ExamDataVO();
			
			obj.setUniquekeyname((String)datalist[0]);
			obj.setExamdate((Date)datalist[3]);
			obj.setExamtype((String)datalist[2]);
			obj.setMadarsaId((int)datalist[4]);
			//obj.setCreatedOn((String)datalist[3]);
			
			
			attendanceList.add(obj);		
		});

		return JsonUtil.convertIntoJson(attendanceList);
	}

	@Override
	public ResponseEntity<JSONResponse<?>> examdetail(String id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sql = " select ex.id,ex.examtype,ex.examyear,ex.studentId,ex.madarsaId,ex.examdate, " + 
				"				ex.theoryNumbers, ex.duaNumbers+ex.namazNumbers as duaNumbers, ex.namazNumbers, "
				+ "ex.userId	, ex.uniquekeyname, u.name , ex.totaltheorynumbers, ex.totalnazranumbers, ex.createdOn from  examsdata ex " + 
				"				left join user u on u.id = ex.studentId and u.userTypeId = 4 "
				+ " where uniquekeyname=:q1 ";
				
				EntityManager enityManager = entityManagerFactory.createEntityManager();

				Query query = (Query) enityManager.createNativeQuery(sql);
				query.setParameter("q1", id);

				List<Object[]> studentRecords = query.getResultList();
				List<ExamDataVO> studentsList = new ArrayList<>();

				studentRecords.forEach(student -> {
					
					ExamDataVO user = new ExamDataVO();
					
					//user.setId((BigInteger) student[0]);
					user.setExamtype((String)student[1]);
					user.setExamyear((int)student[2]);
					user.setStudentId((int)student[3]);
					user.setMadarsaId((int)student[4]);
					
					user.setTheoryNumbers((double)student[6]);
					user.setDuaNumbers((double)student[7]);
					user.setNamazNumbers((double)student[8]);
					
					user.setUniquekeyname((String)student[10]);
					user.setStudentname((String)student[11]);
					user.setTotaltheorynumbers((double)student[12]);
					user.setTotalnazranumbers((double)student[13]);
					
					user.setExamdate((Date)student[14]);
					
					
					
					studentsList.add(user);		
				});

				return JsonUtil.convertIntoJson(studentsList);
	}

	@Override
	public QuestionsAnswersEntity saveAnswers(QuestionsAnswersVOList QuestionsAnswers) {
		// TODO Auto-generated method stub
		QuestionsAnswersEntity answersEnity = null;
		for(QuestionsAnswersVO answer :QuestionsAnswers.getAnswers()) {
			try {
				QuestionsAnswersEntity entity = BeanUtils.shallowCopy(answer, QuestionsAnswersEntity.class);
				entity.setCreatedOn(new Date());
				entity.setLastUpdatedOn(new Date());
				answersEnity = questionsAnswersDAO.save(entity);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return answersEnity;
	}

	@Override
	public ResponseEntity<JSONResponse<?>> feedbackAnswer(String id) {

		String sql = " select an.uniquekeystamp, an.visitDate,q.id, an.answer, q.question que "
				+ " from `exam_question_answers` an" + 
				" left join exam_questions q  on q.`id` = an.`questionId` " + 
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