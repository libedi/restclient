package com.kakaobank.auth.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kakaobank.restclient.convert.JsonStringMessageConverter;
import com.kakaobank.restclient.request.RestPostRequest;

/**
 * 인증 키 요청 DTO
 * @author 박상준
 *
 */
public class E2eIdRequestDto extends RestPostRequest {
	@JsonIgnore
	private final String REQUEST_PATH = "/api/v1/e2e";
	
	private String PublicKey;	// 공개키
	private String UserID;		// 회원ID
	
	public E2eIdRequestDto() {
		this.messageConverter = new JsonStringMessageConverter();
	}
	
	public String getPublicKey() {
		return PublicKey;
	}
	public void setPublicKey(String publicKey) {
		PublicKey = publicKey;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	@Override
	public String getRequestPath() {
		return this.REQUEST_PATH;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("E2eIdRequestDto{\"PublicKey\"=\"").append(PublicKey).append("\", \"UserID\"=\"").append(UserID)
				.append("\"}");
		return builder.toString();
	}
	
}
