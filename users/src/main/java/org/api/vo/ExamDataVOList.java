package org.api.vo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Component
@Scope("prototype")
public class ExamDataVOList {
	@SerializedName("exams")
	@Expose
	private List<ExamDataVO> exams;

	public List<ExamDataVO> getExams() {
		return exams;
	}

	public void setExams(List<ExamDataVO> exams) {
		this.exams = exams;
	}
}
