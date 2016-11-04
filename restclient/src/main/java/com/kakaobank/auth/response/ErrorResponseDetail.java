package com.kakaobank.auth.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ErrorResponseDetail {
	private List<String> codes;
	private List<ErrorArgumentDetail> arguments;
	private String defaultMessage;
	private String objectName;
	private String field;
	private String rejectedValue;
	private String bindingFailure;
	private String code;
	
	public List<String> getCodes() {
		return codes;
	}
	public void setCodes(List<String> codes) {
		this.codes = codes;
	}
	public List<ErrorArgumentDetail> getArguments() {
		return arguments;
	}
	public void setArguments(List<ErrorArgumentDetail> arguments) {
		this.arguments = arguments;
	}
	public String getDefaultMessage() {
		return defaultMessage;
	}
	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getRejectedValue() {
		return rejectedValue;
	}
	public void setRejectedValue(String rejectedValue) {
		this.rejectedValue = rejectedValue;
	}
	public String getBindingFailure() {
		return bindingFailure;
	}
	public void setBindingFailure(String bindingFailure) {
		this.bindingFailure = bindingFailure;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ErrorResponseDetail{\"codes\"=\"").append(codes).append("\", \"arguments\"=\"")
				.append(arguments).append("\", \"defaultMessage\"=\"").append(defaultMessage)
				.append("\", \"objectName\"=\"").append(objectName).append("\", \"field\"=\"").append(field)
				.append("\", \"rejectedValue\"=\"").append(rejectedValue).append("\", \"bindingFailure\"=\"")
				.append(bindingFailure).append("\", \"code\"=\"").append(code).append("\"}");
		return builder.toString();
	}
	
}
