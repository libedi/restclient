package com.kakaobank.auth.response;

import java.util.List;

public class ErrorArgumentDetail {
	private List<String> codes;
	private String arguments;
	private String default_message;
	private String code;
	
	public List<String> getCodes() {
		return codes;
	}
	public void setCodes(List<String> codes) {
		this.codes = codes;
	}
	public String getArguments() {
		return arguments;
	}
	public void setArguments(String arguments) {
		this.arguments = arguments;
	}
	public String getDefault_message() {
		return default_message;
	}
	public void setDefault_message(String default_message) {
		this.default_message = default_message;
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
		builder.append("Arguments{\"codes\"=\"").append(codes).append("\", \"arguments\"=\"").append(arguments)
				.append("\", \"default_message\"=\"").append(default_message).append("\", \"code\"=\"").append(code)
				.append("\"}");
		return builder.toString();
	}
}
