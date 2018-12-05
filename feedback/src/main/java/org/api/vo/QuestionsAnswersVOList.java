package org.api.vo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Component
@Scope("prototype")
public class QuestionsAnswersVOList {
	@SerializedName("answers")
	@Expose
	private List<QuestionsAnswersVO> answers = null;

	public List<QuestionsAnswersVO> getAnswers() {
		return answers;
	}

	public void setAnswers(List<QuestionsAnswersVO> answers) {
		this.answers = answers;
	}

}
