package com.prabu.myrestfulapi.error;

import java.util.Date;
import java.util.List;

public class ErrorDetails {
	
	private List<ApiFieldError> fieldErrors;
	private List<ApiGlobalError> globalErrors;

	

	public ErrorDetails(List<ApiFieldError> fieldErrors, List<ApiGlobalError> globalErrors) {
		super();
		this.fieldErrors = fieldErrors;
		this.globalErrors = globalErrors;
	}

	public List<ApiFieldError> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<ApiFieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	public List<ApiGlobalError> getGlobalErrors() {
		return globalErrors;
	}

	public void setGlobalErrors(List<ApiGlobalError> globalErrors) {
		this.globalErrors = globalErrors;
	}
	  

}
