package org.api.services.impl;


import org.api.model.jpa.entity.OrganizationNotificationsEntity;
import org.api.vo.OrganizationNotificationListVO;
import org.api.vo.OrganizationNotificationsVO;
import org.core.service.CRUDService;
import org.core.view.JSONResponse;
import org.springframework.http.ResponseEntity;

public interface OrganizationNotificationService extends CRUDService<OrganizationNotificationsVO> {
	public ResponseEntity<JSONResponse<?>> getListNotifications();
	public OrganizationNotificationsEntity saveAnswers(OrganizationNotificationListVO examData);
	public ResponseEntity<JSONResponse<?>> getdatacounts();
	
	public ResponseEntity<JSONResponse<?>> alreadyexist(String value);
}
