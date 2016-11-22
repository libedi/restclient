package com.kakaobank.auth.request;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kakaobank.restclient.convert.JsonStringMessageConverter;

/**
 * 회원 휴대폰 확인 검증 요청 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MobileValidForCustRequestDto extends MobileValidRequestDto {
	@JsonIgnore
	private final String REQUEST_PATH = "/api/v1/authentications/:userId/mobile/";
	
	@NotEmpty
	private String userId;	// 사용자관리번호
	
	public MobileValidForCustRequestDto() {
		this.messageConverter = new JsonStringMessageConverter();
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
		return new StringBuilder()
				.append(this.REQUEST_PATH.replace(":userId", this.userId)).append(this.decryptedValidationId)
				.toString();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileValidForCustRequestDto{\"userId\"=\"").append(userId)
				.append("\", \"decryptedValidationId\"=\"").append(decryptedValidationId)
				.append("\", \"validationId\"=\"").append(validationId).append("\", \"arthNo\"=\"").append(arthNo)
				.append("\", \"e2eId\"=\"").append(e2eId).append("\"}");
		return builder.toString();
	}
}
