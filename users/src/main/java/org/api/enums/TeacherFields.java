package org.api.enums;

public enum TeacherFields {
	
	EasyAccountTitle("EasyAccountTitle")
	, ENIC("ENIC")
	, eMobileNumber("eMobileNumber")
	, madarsaId("madarsaId")
	, salary("salary")
	, benefitamount("benefitamount");

	private String teacherFields;
	TeacherFields(String teacherField) {
		this.teacherFields = teacherField;
	}

	public String getFields() {
		return this.teacherFields;
	}
}
