package com.kakaobank.auth.request;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kakaobank.restclient.convert.MessageConverterFactory;
import com.kakaobank.restclient.convert.MessageType;
import com.kakaobank.restclient.request.RestGetRequest;

/**
 * 사용자 인증 상태 조회 요청 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserAuthStatusRequestDto extends RestGetRequest{
	@JsonIgnore
	private final String REQUEST_PATH = "/api/v1/users/";
	
	@JsonIgnore
	@NotEmpty
	private String userId;	// 사용자관리번호
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserAuthStatusRequestDto{\"userId\"=\"").append(userId).append("\"}");
		return builder.toString();
	}
	@Override
	public String getRequestPath() {
		return new StringBuilder().append(this.REQUEST_PATH).append(this.getUserId()).toString();
	}
	@Override
	protected void setMessageConverter() {
		this.messageConverter = MessageConverterFactory.createMessageConverter(MessageType.URL);
	}

}
