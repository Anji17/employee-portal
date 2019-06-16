package com.test.employee.dto;

public class EmployeeDTO {

	Object data;
	int statusCode;
	String statusMessage;
	public EmployeeDTO(Object data, int statusCode, String statusMessage) {
		super();
		this.data = data;
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
}
