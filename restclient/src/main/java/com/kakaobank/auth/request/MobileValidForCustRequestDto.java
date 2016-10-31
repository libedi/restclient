package com.kakaobank.auth.request;

import com.kakaobank.restclient.convert.JsonStringMessageConverter;

/**
 * 회원 휴대폰 확인 검증 요청 DTO
 * @author 박상준
 *
 */
public class MobileValidForCustRequestDto extends MobileValidRequestDto {
private final String REQUEST_PATH = "/api/v1/authentication/:userId/mobile/";
	
	private String UserID;	// 회원ID
	
	public MobileValidForCustRequestDto() {
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
		return new StringBuilder()
				.append(this.REQUEST_PATH.replace(":userId", this.UserID)).append(this.ValidationID)
				.toString();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileValidForCustRequestDto{\"UserID\"=\"").append(UserID).append("\", \"ValidationID\"=\"")
				.append(ValidationID).append("\", \"ArthNo\"=\"").append(ArthNo).append("\"}");
		return builder.toString();
	}

}
