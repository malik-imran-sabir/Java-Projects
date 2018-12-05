package org.api.vo;

import java.util.Date;

import org.core.vo.BaseVO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class OrganizationNotificationsVO extends BaseVO {
	
	private long id;
	private String notification;
	private Date expiredOn;
	
	public Long getId() {
		return id;
	}
	

	public void setId(long id) {
		this.id = id;
	}
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}


	public Date getExpiredOn() {
		return expiredOn;
	}


	public void setExpiredOn(Date expiredOn) {
		this.expiredOn = expiredOn;
	}
	
	
	
	
	
}
