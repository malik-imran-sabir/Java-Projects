package org.api.vo;

import org.core.vo.BaseVO;

public class QuestionsVO extends BaseVO{
	
	private long id;
	
	private String question;
	
	private String option;
	
	private long type;

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

}
