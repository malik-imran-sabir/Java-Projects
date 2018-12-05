package org.api.enums;

public enum UserTypes {
	
	nigran(1)
	,teacher(2)
	,employee(3)
	,student(4);

	private int userTypes;
	UserTypes(int userTypes) {
		this.userTypes = userTypes;
	}

	public int getFields() {
		return this.userTypes;
	}
}
