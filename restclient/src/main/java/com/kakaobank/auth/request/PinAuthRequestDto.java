package com.kakaobank.auth.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kakaobank.restclient.convert.JsonStringMessageConverter;

/**
 * PIN / 해제번호 인증 요청 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PinAuthRequestDto extends EncryptedRequest {
	@JsonIgnore
	private final String REQUEST_PATH = "/api/v1/authentications/:userID/pin";
	
	@NotEmpty
	private String userId;			// 사용자관리번호
	@NotEmpty
	@Size(min=6, max=6)
	private String tellerId;		// 상담원ID
	@NotEmpty
	private List<String> value;		// E2E 암호화된 PIN / 해제번호
	@JsonIgnore
	private String pinNum;			// PIN / 해제번호
	
	public PinAuthRequestDto() {
		this.messageConverter = new JsonStringMessageConverter();
		this.value = new ArrayList<String>();
		this.guid = this.makeGuid();
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTellerId() {
		return tellerId;
	}
	public void setTellerId(String tellerId) {
		this.tellerId = tellerId;
	}
	public List<String> getValue() {
		return value;
	}
	public void setValue(List<String> value) {
		this.value = value;
	}
	public void setValue(String pinNum){
		this.value.add(pinNum);
	}
	public String getPinNum() {
		return pinNum;
	}
	public void setPinNum(String pinNum) {
		this.pinNum = pinNum;
	}
	@Override
	public String getRequestPath() {
		return this.REQUEST_PATH.replace(":userID", this.userId);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PinAuthRequestDto{\"userId\"=\"").append(userId).append("\", \"tellerId\"=\"").append(tellerId)
				.append("\", \"value\"=\"").append(value).append("\", \"pinNum\"=\"").append(pinNum)
				.append("\", \"e2eId\"=\"").append(e2eId).append("\", \"guid\"=\"").append(guid).append("\"}");
		return builder.toString();
	}
	
}
