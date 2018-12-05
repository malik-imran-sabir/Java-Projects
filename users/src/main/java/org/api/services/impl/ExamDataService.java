package org.api.services.impl;

import org.api.model.jpa.entity.ExamDataEntity;
import org.api.model.jpa.entity.QuestionsAnswersEntity;
import org.api.vo.ExamDataVO;
import org.api.vo.ExamDataVOList;
import org.api.vo.QuestionsAnswersVOList;
import org.core.service.CRUDService;
import org.core.view.JSONResponse;
import org.springframework.http.ResponseEntity;

public interface ExamDataService extends CRUDService<ExamDataVO>{
	
	public ResponseEntity<JSONResponse<?>> getExamList();
	public ResponseEntity<JSONResponse<?>> getExamListbyKey(String uniquekeyname);
	public ExamDataEntity saveAnswers(ExamDataVOList examData);
	
	public ResponseEntity<JSONResponse<?>> examlist();
	
	public ResponseEntity<JSONResponse<?>> examdetail(String id);
	
	public QuestionsAnswersEntity saveAnswers(QuestionsAnswersVOList QuestionsAnswers);
	
	public ResponseEntity<JSONResponse<?>> feedbackAnswer(String id);

	
}