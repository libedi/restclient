package com.kakaobank.restclient.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.kakaobank.restclient.convert.MessageConverterFactory;
import com.kakaobank.restclient.convert.MessageType;
import com.kakaobank.restclient.request.RestPostRequest;

@JsonInclude(Include.NON_NULL)
public class TestRequestDto extends RestPostRequest {
	private String UserID;
	private String Value;
	private String e2eID;

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	public String getE2eID() {
		return e2eID;
	}

	public void setE2eID(String e2eID) {
		this.e2eID = e2eID;
	}

	public String getRequestPath() {
		return "/api/v1/e2e";
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TestRequestDto{\"UserID\"=\"").append(UserID).append("\", \"Value\"=\"").append(Value)
				.append("\", \"e2eID\"=\"").append(e2eID).append("\"}");
		return builder.toString();
	}

	@Override
	protected void setMessageConverter() {
		this.messageConverter = MessageConverterFactory.createMessageConverter(MessageType.JSON);
	}
	
}
