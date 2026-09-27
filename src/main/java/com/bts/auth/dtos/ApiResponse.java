package com.bts.auth.dtos;

public class ApiResponse<T> {
	private String message;
	private T response;
	
	public ApiResponse() {
		super();
	}
	
	public ApiResponse(String message, T response) {
		super();
		this.message = message;
		this.response = response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}
	
}
