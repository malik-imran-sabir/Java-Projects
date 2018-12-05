package org.api.vo;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.api.model.jpa.entity.AttendanceEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Shift {
	private String shiftId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp startTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp endTime;
	private Collection<AttendanceEntity> students;
	
	private String lessonStart;
	private String lessonEnd;
	
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
	public Collection<AttendanceEntity> getStudents() {
		return students;
	}
	public void setStudents(List<AttendanceEntity> students) {
		this.students = students;
	}
	public String getShiftId() {
		return shiftId;
	}
	public void setShiftId(String shiftId) {
		this.shiftId = shiftId;
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
