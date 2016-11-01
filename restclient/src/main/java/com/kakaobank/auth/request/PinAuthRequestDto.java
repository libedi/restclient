package com.kakaobank.auth.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.kakaobank.restclient.convert.JsonStringMessageConverter;

/**
 * PIN / 해제번호 인증 요청 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
public class PinAuthRequestDto extends EncryptedRequest {
	@JsonIgnore
	private final String REQUEST_PATH = "/api/v1/authentications/:userID/pin";
	
	private String user_id;			// 사용자관리번호
	private List<String> value;		// E2E 암호화된 PIN / 해제번호
	@JsonIgnore
	private String pinNum;			// PIN / 해제번호
	
	public PinAuthRequestDto() {
		this.messageConverter = new JsonStringMessageConverter();
		this.value = new ArrayList<String>();
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public List<String> getValue() {
		return value;
	}
	public void setValue(List<String> value) {
		this.value = value;
	}
	public void setValue(String value) {
		this.value.add(value);
	}
	public String getPinNum() {
		return pinNum;
	}
	public void setPinNum(String pinNum) {
		this.pinNum = pinNum;
	}
	@Override
	public String getRequestPath() {
		return this.REQUEST_PATH.replace(":userID", this.user_id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PinAuthRequestDto{\"user_id\"=\"").append(user_id).append("\", \"value\"=\"").append(value)
				.append("\", \"e2e_id\"=\"").append(e2e_id).append("\"}");
		return builder.toString();
	}
}
