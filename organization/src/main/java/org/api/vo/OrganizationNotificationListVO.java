package org.api.vo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Component
@Scope("prototype")
public class OrganizationNotificationListVO {
	@SerializedName("notifications")
	@Expose
	private List<OrganizationNotificationsVO> notifications;

	public List<OrganizationNotificationsVO> getNotifications() {
		return notifications;
	}

	public void setExams(List<OrganizationNotificationsVO> exams) {
		this.notifications = exams;
	}
}
