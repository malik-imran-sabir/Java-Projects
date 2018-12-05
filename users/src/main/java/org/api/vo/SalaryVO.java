package org.api.vo;

import java.sql.Date;

import org.core.vo.BaseVO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SalaryVO extends BaseVO  {
	private long id;
	private Date salarydate;
	

	public Date getSalarydate() {
		return salarydate;
	}
	public void setSalarydate(Date salarydate) {
		this.salarydate = salarydate;
	}
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

}
