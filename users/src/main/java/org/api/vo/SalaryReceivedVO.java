package org.api.vo;

import java.sql.Date;

import org.core.vo.BaseVO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SalaryReceivedVO extends BaseVO  {
	private long id;
	private int userId;
	private Date receivedOn;
	private int salaryId;
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getReceivedOn() {
		return receivedOn;
	}
	public void setReceivedOn(Date receivedOn) {
		this.receivedOn = receivedOn;
	}
	public int getSalaryId() {
		return salaryId;
	}
	public void setSalaryId(int salaryId) {
		this.salaryId = salaryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
