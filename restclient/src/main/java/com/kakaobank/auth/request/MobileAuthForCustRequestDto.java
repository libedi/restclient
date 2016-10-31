package com.kakaobank.auth.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kakaobank.restclient.convert.JsonStringMessageConverter;

/**
 * 회원 휴대폰 확인 요청 DTO
 * @author 박상준
 *
 */
public class MobileAuthForCustRequestDto extends MobileAuthRequestDto {
	@JsonIgnore
	private final String REQUEST_PATH = "/api/v1/authentications/:userId/mobile";

	private String UserID;	// 회원ID
	
	public MobileAuthForCustRequestDto() {
		this.messageConverter = new JsonStringMessageConverter();
	}
	
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	@Override
	public String getRequestPath() {
		return this.REQUEST_PATH.replace(":userId", this.UserID);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileAuthForCustRequestDto{\"UserID\"=\"").append(UserID).append("\", \"VenderCode\"=\"")
				.append(VenderCode).append("\", \"PhoneNumber\"=\"").append(PhoneNumber).append("\", \"Name\"=\"")
				.append(Name).append("\", \"BirthDay\"=\"").append(BirthDay).append("\", \"e2eID\"=\"").append(e2eID)
				.append("\"}");
		return builder.toString();
	}
}
