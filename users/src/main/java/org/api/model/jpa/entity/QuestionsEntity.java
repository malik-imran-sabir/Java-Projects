package org.api.model.jpa.entity;

import java.text.Normalizer.Form;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.core.model.entity.BaseEntity;

@Entity
@Table(name="exam_questions")
public class QuestionsEntity extends BaseEntity {
	
	@Column
	private String question;
	
	@Column
	private String option;
	
	@Column
	private long type;

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
