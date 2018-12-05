package org.api.vo;

import java.sql.Date;
import java.sql.Timestamp;

import org.core.vo.BaseVO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class AttendanceVO extends BaseVO {

	private long id;

	private String userId;
	
	private String classId;
	
	private String shiftId;
	
	private Date date;

	private Timestamp startTime;
	
	private Timestamp endTime;
	
	private String lessonStart;
	
	private String lessonEnd;
	
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
	
}
