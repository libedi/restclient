package com.kakaobank.auth.response;

import java.util.List;

public class ErrorResponseDetail {
	private List<String> codes;
	private List<ErrorArgumentDetail> arguments;
	private String default_message;
	private String object_name;
	private String field;
	private String rejected_value;
	private String binding_failure;
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
	public String getDefault_message() {
		return default_message;
	}
	public void setDefault_message(String default_message) {
		this.default_message = default_message;
	}
	public String getObject_name() {
		return object_name;
	}
	public void setObject_name(String object_name) {
		this.object_name = object_name;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getRejected_value() {
		return rejected_value;
	}
	public void setRejected_value(String rejected_value) {
		this.rejected_value = rejected_value;
	}
	public String getBinding_failure() {
		return binding_failure;
	}
	public void setBinding_failure(String binding_failure) {
		this.binding_failure = binding_failure;
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
				.append(arguments).append("\", \"default_message\"=\"").append(default_message)
				.append("\", \"object_name\"=\"").append(object_name).append("\", \"field\"=\"").append(field)
				.append("\", \"rejected_value\"=\"").append(rejected_value).append("\", \"binding_failure\"=\"")
				.append(binding_failure).append("\", \"code\"=\"").append(code).append("\"}");
		return builder.toString();
	}
}
