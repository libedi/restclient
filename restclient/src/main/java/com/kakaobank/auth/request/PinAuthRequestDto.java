package com.kakaobank.auth.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kakaobank.restclient.convert.JsonStringMessageConverter;

/**
 * PIN / 해제번호 인증 요청 DTO
 * @author 박상준
 *
 */
public class PinAuthRequestDto extends EncryptedRequest {
	@JsonIgnore
	private final String REQUEST_PATH = "/api/v1/authentications/:userID/pin";
	
	private String UserID;		// 회원ID
	private String Value;		// E2E 암호화된 PIN / 해제번호
	
	public PinAuthRequestDto() {
		this.messageConverter = new JsonStringMessageConverter();
	}
	
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
	@Override
	public String getRequestPath() {
		return this.REQUEST_PATH.replace(":userID", this.UserID);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PinAuthRequestDto{\"UserID\"=\"").append(UserID).append("\", \"Value\"=\"").append(Value)
				.append("\", \"e2eID\"=\"").append(e2eID).append("\"}");
		return builder.toString();
	}
	
}
