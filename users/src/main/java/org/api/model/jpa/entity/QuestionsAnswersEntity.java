package org.api.model.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.core.model.entity.BaseEntity;

@Entity
@Table(name="exam_question_answers")
public class QuestionsAnswersEntity extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	
	@Column
	private String questionId;
	
	@Column
	private String answer;

	@Column
	private long userId;
	
	@Column
	private Date visitDate;
	
	@Column
	private  long madarsaId;
	
	@Column
	private String uniquekeystamp;
	
	
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public long getMadarsaId() {
		return madarsaId;
	}

	public void setMadarsaId(long madarsaId) {
		this.madarsaId = madarsaId;
	}

	public String getUniquekeystamp() {
		return uniquekeystamp;
	}

	public void setUniquekeystamp(String uniquekeystamp) {
		this.uniquekeystamp = uniquekeystamp;
	}
	
}
