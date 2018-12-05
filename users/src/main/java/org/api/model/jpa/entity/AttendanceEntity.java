package org.api.model.jpa.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.core.model.entity.BaseEntity;

@Entity
@Table(name = "attendance")
public class AttendanceEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;

	@Column
	private String userId;
	
	@Column
	private String classId;
	
	@Column
	private String shiftId;
	
	@Column
	private Date date;

	@Column
	private Timestamp startTime;
	
	@Column
	private Timestamp endTime;
	
	@Column
	private String presenceStatus;
	
	@Column
	private String lessonStart;
	
	@Column
	private String lessonEnd;

	public String getPresenceStatus() {
		return presenceStatus;
	}

	public void setPresenceStatus(String presenceStatus) {
		this.presenceStatus = presenceStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getShiftId() {
		return shiftId;
	}

	public void setShiftId(String shiftId) {
		this.shiftId = shiftId;
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
	
/*	@Column
	private Date creationDate;
	
	@Column
	private String atdStatus;
	
	@Column
	private String lessonFrom;
	
	@Column
	private String lessonTo;
	
	@Column
	private String verified;
	
	@Column
	private String verifyComments;*/


}
