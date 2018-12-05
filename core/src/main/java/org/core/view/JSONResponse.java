package org.core.view;

public class JSONResponse<T> {

	private String status;
	private String message;
	private T data;

	
	public JSONResponse() {
		// TODO Auto-generated constructor stub
	}

	public JSONResponse(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
