package com.kakaobank.auth.request;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * 회원 휴대폰 확인 요청 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MobileAuthForCustRequestDto extends MobileAuthRequestDto {
	@JsonIgnore
	private final String REQUEST_PATH = "/api/v1/authentications/:userId/mobile";

	@NotEmpty
	private String userId;	// 사용자관리번호
	
	public MobileAuthForCustRequestDto() {
		this.makeDefaultHeader();
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String getRequestPath() {
		return this.REQUEST_PATH.replace(":userId", this.userId);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileAuthForCustRequestDto{\"userId\"=\"").append(userId).append("\", \"vendorCode\"=\"")
				.append(vendorCode).append("\", \"phoneNumber\"=\"").append(phoneNumber).append("\", \"name\"=\"")
				.append(name).append("\", \"birthdayAndGender\"=\"").append(birthdayAndGender)
				.append("\", \"e2eId\"=\"").append(e2eId).append("\"}");
		return builder.toString();
	}
}
