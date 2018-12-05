package org.api.vo;

import java.util.Date;

import org.core.vo.BaseVO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Component
@Scope("prototype")
public class QuestionsAnswersVO extends BaseVO{
	
	private long id;
	
	private long userId;

	private Date visitDate;
	
	private  int madarsaId;
	
	private String uniquekeystamp;
	
	
	@Expose
	@SerializedName("question")
	private String question;

	
	@Expose
	@SerializedName("answer")
	private String answer;

	@Expose
	@SerializedName("questionId")
	private String questionId;
	
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getUniquekeystamp() {
		return uniquekeystamp;
	}

	public void setUniquekeystamp(String uniquekeystamp) {
		this.uniquekeystamp = uniquekeystamp;
	}


	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getMadarsaId() {
		return madarsaId;
	}

	public void setMadarsaId(int madarsaId) {
		this.madarsaId = madarsaId;
	}

}
