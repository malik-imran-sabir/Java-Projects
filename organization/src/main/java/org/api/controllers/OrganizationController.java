package org.api.controllers;

import org.api.model.jpa.entity.OrganizationNotificationsEntity;
import org.api.services.impl.OrganizationNotificationService;
import org.api.vo.OrganizationNotificationListVO;
import org.api.vo.OrganizationVO;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/org")
public class OrganizationController extends BaseController<OrganizationVO>{
	
	@Autowired
	private OrganizationNotificationService orgnotService;

	@Autowired
	public OrganizationController(CRUDService<OrganizationVO> service) {
		super(service);
	}
	
	@GetMapping("/getnotificationslist/")
	public ResponseEntity<JSONResponse<?>> getListNotifications() {
		return orgnotService.getListNotifications();
	}
	
	@PostMapping("/save-notifications")
	public ResponseEntity<JSONResponse<?>> saveFeedback(@RequestBody  OrganizationNotificationListVO questionsAnswers) {
		try {
			OrganizationNotificationsEntity entity =  orgnotService.saveAnswers(questionsAnswers);
			return JsonUtil.convertSingleEntityToJson(entity);
			
		} catch (Throwable e) {
			e.printStackTrace();	
			return null;
		}
		
	}
	
	
	@GetMapping("/getcounts/")
	public ResponseEntity<JSONResponse<?>> getcounts() {
		return orgnotService.getdatacounts();
	}
	
	
	@GetMapping("/alreadyexist/{value}")
	public ResponseEntity<JSONResponse<?>> alreadyexist(@PathVariable("value") String value) {
		return orgnotService.alreadyexist(value);
	}

}
