package org.api.enums;

public enum StudentFields {
	
	fathernic("fathernic")
	,address("address")
	,locationId("locationId")
	,teacherId("teacherId")
	,shiftId("shiftId")
	,classId("classId");

	private String studentFields;
	StudentFields(String teacherField) {
		this.studentFields = teacherField;
	}

	public String getFields() {
		return this.studentFields;
	}
}
