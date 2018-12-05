package org.api.vo;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AttendanceBulkVO {
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private Collection<Shift> shifts;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Collection<Shift> getShifts() {
		return shifts;
	}
	
	public void setShifts(Collection<Shift> shifts) {
		this.shifts = shifts;
	}
}
