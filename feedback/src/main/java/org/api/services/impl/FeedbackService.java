package org.api.services.impl;

import org.api.model.jpa.entity.QuestionsAnswersEntity;
import org.api.vo.QuestionsAnswersVO;
import org.api.vo.QuestionsAnswersVOList;
import org.core.service.CRUDService;
import org.core.view.JSONResponse;
import org.springframework.http.ResponseEntity;

public interface FeedbackService extends CRUDService<QuestionsAnswersVO>{
	
	public QuestionsAnswersEntity saveAnswers(QuestionsAnswersVOList QuestionsAnswers);
	
	public ResponseEntity<JSONResponse<?>> listAnswers();
	
	public ResponseEntity<JSONResponse<?>> feedbackAnswer(String id);
	
}
