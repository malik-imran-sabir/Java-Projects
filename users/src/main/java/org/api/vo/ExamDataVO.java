package org.api.vo;

import java.util.Date;

import org.core.vo.BaseVO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ExamDataVO extends BaseVO {
	
	private long id;
	private String examtype;
	private int examyear;
	private int studentId;
	private int madarsaId;
	private Date examdate;
	private int userId;
	private String comments;
	private double theoryNumbers;
	private double duaNumbers;
	private double namazNumbers;
	private String uniquekeyname;
	private String studentname;
	private double totaltheorynumbers;
	private double totalnazranumbers ;
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getExamtype() {
		return examtype;
	}
	public void setExamtype(String examtype) {
		this.examtype = examtype;
	}
	public int getExamyear() {
		return examyear;
	}
	public void setExamyear(int examyear) {
		this.examyear = examyear;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getMadarsaId() {
		return madarsaId;
	}
	public void setMadarsaId(int madarsaId) {
		this.madarsaId = madarsaId;
	}
	public Date getExamdate() {
		return examdate;
	}
	public void setExamdate(Date examdate) {
		this.examdate = examdate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public double getTheoryNumbers() {
		return theoryNumbers;
	}
	public void setTheoryNumbers(double theoryNumbers) {
		this.theoryNumbers = theoryNumbers;
	}
	public double getDuaNumbers() {
		return duaNumbers;
	}
	public void setDuaNumbers(double duaNumbers) {
		this.duaNumbers = duaNumbers;
	}
	public double getNamazNumbers() {
		return namazNumbers;
	}
	public void setNamazNumbers(double namazNumbers) {
		this.namazNumbers = namazNumbers;
	}
	public String getUniquekeyname() {
		return uniquekeyname;
	}
	public void setUniquekeyname(String uniquekeyname) {
		this.uniquekeyname = uniquekeyname;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public double getTotaltheorynumbers() {
		return totaltheorynumbers;
	}
	public void setTotaltheorynumbers(double totaltheorynumbers) {
		this.totaltheorynumbers = totaltheorynumbers;
	}
	public double getTotalnazranumbers() {
		return totalnazranumbers;
	}
	public void setTotalnazranumbers(double totalnazranumbers) {
		this.totalnazranumbers = totalnazranumbers;
	}
}
