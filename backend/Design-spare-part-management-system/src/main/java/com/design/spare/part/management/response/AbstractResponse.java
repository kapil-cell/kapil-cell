package com.design.spare.part.management.response;

public class AbstractResponse {

	
	int code;
	String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "AbtractResponse [code=" + code + ", message=" + message + "]";
	}
	
	
}
