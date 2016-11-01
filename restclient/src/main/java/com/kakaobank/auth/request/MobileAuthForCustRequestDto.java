package com.kakaobank.auth.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.kakaobank.restclient.convert.JsonStringMessageConverter;

/**
 * 회원 휴대폰 확인 요청 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
public class MobileAuthForCustRequestDto extends MobileAuthRequestDto {
	@JsonIgnore
	private final String REQUEST_PATH = "/api/v1/authentications/:userId/mobile";

	private String user_id;	// 사용자관리번호
	
	public MobileAuthForCustRequestDto() {
		this.messageConverter = new JsonStringMessageConverter();
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String getRequestPath() {
		return this.REQUEST_PATH.replace(":userId", this.user_id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileAuthForCustRequestDto{\"user_id\"=\"").append(user_id).append("\", \"VenderCode\"=\"")
				.append(VenderCode).append("\", \"PhoneNumber\"=\"").append(PhoneNumber).append("\", \"Name\"=\"")
				.append(Name).append("\", \"BirthDay\"=\"").append(BirthDay).append("\", \"e2e_id\"=\"").append(e2e_id)
				.append("\"}");
		return builder.toString();
	}
	
}
