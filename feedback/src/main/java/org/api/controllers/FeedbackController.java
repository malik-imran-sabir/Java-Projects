package org.api.controllers;

import org.api.model.jpa.dao.JPAQuestionsDAO;
import org.api.model.jpa.entity.QuestionsAnswersEntity;
import org.api.services.impl.FeedbackService;
import org.api.vo.QuestionsAnswersVO;
import org.api.vo.QuestionsAnswersVOList;
import org.core.service.CRUDService;
import org.core.util.JsonUtil;
import org.core.view.JSONResponse;
import org.core.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedbackController extends BaseController<QuestionsAnswersVO>{
	
	@Autowired
	public FeedbackController(CRUDService<QuestionsAnswersVO> service) {
		super(service);
	}

	@Autowired
	private JPAQuestionsDAO qService;
	
	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping("/list-questions")
	public ResponseEntity<JSONResponse<?>> questions() {
		try {
			return JsonUtil.convertIntoJson(qService.findAll());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	@GetMapping("/list-feedbacks")
	public ResponseEntity<JSONResponse<?>> listfeedbacks() {
		return feedbackService.listAnswers();
	}
	
	
	@GetMapping("/list-answers")
	public ResponseEntity<JSONResponse<?>> listAnswers() {
		return feedbackService.listAnswers();
	}
	
	@GetMapping("/feedback-answer/{id}")
	public ResponseEntity<JSONResponse<?>> feedbackAnswer(@PathVariable("id") String id) {
		return feedbackService.feedbackAnswer(id);
	}
	

	@PostMapping("/save-feedback")
	public ResponseEntity<JSONResponse<?>> saveFeedback(@RequestBody  QuestionsAnswersVOList questionsAnswers) {
		try {
			QuestionsAnswersEntity entity =  feedbackService.saveAnswers(questionsAnswers);
			return JsonUtil.convertSingleEntityToJson(entity);
			
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@PostMapping("/save-feedback2")
	public ResponseEntity<JSONResponse<?>> saveFeedback2(@RequestBody  QuestionsAnswersVOList questionsAnswers) {
		try {
			QuestionsAnswersEntity entity =  feedbackService.saveAnswers(questionsAnswers);
			return JsonUtil.convertSingleEntityToJson(entity);
			
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
