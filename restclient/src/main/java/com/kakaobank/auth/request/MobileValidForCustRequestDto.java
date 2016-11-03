package com.kakaobank.auth.request;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.kakaobank.restclient.convert.JsonStringMessageConverter;

/**
 * 회원 휴대폰 확인 검증 요청 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
public class MobileValidForCustRequestDto extends MobileValidRequestDto {
	private final String REQUEST_PATH = "/api/v1/authentication/:userId/mobile/";
	
	@NotEmpty
	private String user_id;	// 사용자관리번호
	
	public MobileValidForCustRequestDto() {
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
		return new StringBuilder()
				.append(this.REQUEST_PATH.replace(":userId", this.user_id)).append(this.validation_id)
				.toString();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileValidForCustRequestDto{\"user_id\"=\"").append(user_id).append("\", \"validation_id\"=\"")
				.append(validation_id).append("\", \"arth_no\"=\"").append(arth_no)
				.append("\", \"messageConverter\"=\"").append(messageConverter).append("\"}");
		return builder.toString();
	}

}
