package com.kakaobank.auth.request;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.kakaobank.restclient.convert.JsonStringMessageConverter;
import com.kakaobank.restclient.request.RestPostRequest;

/**
 * 인증 키 요청 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
public class E2eIdRequestDto extends RestPostRequest {
	@JsonIgnore
	private final String REQUEST_PATH = "/api/v1/e2e";
	
	@NotEmpty
	private String public_key;		// 공개키
	private String user_id;			// 사용자관리번호
	@NotEmpty
	@Size(min=6, max=6)
	private String teller_id;		// 상담원ID
	
	public E2eIdRequestDto() {
		this.messageConverter = new JsonStringMessageConverter();
	}

	public String getPublic_key() {
		return public_key;
	}
	public void setPublic_key(String public_key) {
		this.public_key = public_key;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTeller_id() {
		return teller_id;
	}
	public void setTeller_id(String teller_id) {
		this.teller_id = teller_id;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("E2eIdRequestDto{\"public_key\"=\"").append(public_key).append("\", \"user_id\"=\"")
				.append(user_id).append("\", \"teller_id\"=\"").append(teller_id).append("\"}");
		return builder.toString();
	}
	@Override
	public String getRequestPath() {
		return this.REQUEST_PATH;
	}
	
}
