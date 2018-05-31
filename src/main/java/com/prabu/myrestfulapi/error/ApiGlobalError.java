package com.prabu.myrestfulapi.error;

public class ApiGlobalError {

	public ApiGlobalError(String code) {
		this.code = code;
	}

	public ApiGlobalError() {
	}

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
