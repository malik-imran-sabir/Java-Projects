package org.api.model.jpa.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.core.model.entity.BaseEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="examsdata")
public class ExamDataEntity extends BaseEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	
	@Column
	private String examtype;
	
	@Column
	private int examyear;
	
	@Column
	private int studentId;
	
	@Column
	private int madarsaId;
	
	@Column
	private Date examdate;
	
	@Column
	private int userId;
	
	@Column
	private String comments;
	
	@Column
	private double theoryNumbers;
	
	@Column
	private double duaNumbers;
	
	@Column
	private double namazNumbers;
	
	@Column
	private String uniquekeyname;
	
	@Column
	private String studentname;
	
	@Column
	private double totaltheorynumbers;
	
	@Column
	private double totalnazranumbers;

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