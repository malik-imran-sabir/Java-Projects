package org.api.model.jpa.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.core.model.entity.BaseEntity;


@Entity
@Table(name="salary_received")
public class SalaryReceivedEntity extends BaseEntity {
	
	private long id;
	
	@Column
	private int userId;
	
	@Column
	private Date receivedOn;
	
	@Column
	private int salaryId;
	
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
	
}
