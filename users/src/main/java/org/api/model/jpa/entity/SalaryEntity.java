package org.api.model.jpa.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.core.model.entity.BaseEntity;


@Entity
@Table(name="salary")
public class SalaryEntity extends BaseEntity {
	
	private long id;
	private Date salarydate;
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getSalarydate() {
		return salarydate;
	}
	public void setSalarydate(Date salarydate) {
		this.salarydate = salarydate;
	}
	
}
