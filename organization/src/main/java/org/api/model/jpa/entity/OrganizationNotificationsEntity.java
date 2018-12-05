package org.api.model.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Date;

import javax.persistence.Column;

import org.core.model.entity.BaseEntity;

@Entity
@Table(name="organizationnotifications")
public class OrganizationNotificationsEntity  extends BaseEntity {
	
	@Column
	private long id;
	
	@Column
	private String notification;
	
	@Column
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
