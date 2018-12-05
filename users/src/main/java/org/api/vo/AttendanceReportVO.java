package org.api.vo;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

public class AttendanceReportVO {
	
	private BigInteger id;
	
	private String name;
	
	private String fathername;
	
	private Date doj;
	
	private Date date;

	private Timestamp startTime;
	
	private Timestamp endTime;
	
	private String lessonStart;
	
	private String lessonEnd;
	
	private String presenceStatus;
	
	private String madrasaname;
	
	private String classname;


	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getLessonStart() {
		return lessonStart;
	}

	public void setLessonStart(String lessonStart) {
		this.lessonStart = lessonStart;
	}

	public String getLessonEnd() {
		return lessonEnd;
	}

	public void setLessonEnd(String lessonEnd) {
		this.lessonEnd = lessonEnd;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getPresenceStatus() {
		return presenceStatus;
	}

	public void setPresenceStatus(String presenceStatus) {
		this.presenceStatus = presenceStatus;
	}

	public String getMadrasaname() {
		return madrasaname;
	}

	public void setMadrasaname(String madrasaname) {
		this.madrasaname = madrasaname;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}
}
