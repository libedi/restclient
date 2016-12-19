package com.kakaobank.auth.request;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kakaobank.restclient.convert.MessageConverterFactory;
import com.kakaobank.restclient.convert.MessageType;
import com.kakaobank.restclient.request.RestPostRequest;

/**
 * 인증 키 요청 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class E2eIdRequestDto extends RestPostRequest {
	@JsonIgnore
	private final String REQUEST_PATH = "/api/v1/e2e";
	
	@NotEmpty
	private String publicKey;		// 공개키
	private String userId;			// 사용자관리번호
	@NotEmpty
	@Size(min=6, max=6)
	private String tellerId;		// 상담원ID
	
	private Integer num;
	
	public E2eIdRequestDto() {
		this.makeDefaultHeader();
	}

	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
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
	
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("E2eIdRequestDto{\"publicKey\"=\"").append(publicKey).append("\", \"userId\"=\"").append(userId)
				.append("\", \"tellerId\"=\"").append(tellerId).append("\"}");
		return builder.toString();
	}
	@Override
	public String getRequestPath() {
		return this.REQUEST_PATH;
	}
	
	private void makeDefaultHeader(){
		String guid = new StringBuilder()
				.append("037CCSTMA039D")
				.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()))
				.append(String.format("%06d", (int) (Math.random() * 1000000)))
				.append("001")
				.toString();
		this.headerMap = new HashMap<>();
		this.headerMap.put("X-KKB-CSTNO", "-1");
		this.headerMap.put("X-KKB-GUID", guid);
	}

	@Override
	protected void setMessageConverter() {
		this.messageConverter = MessageConverterFactory.createMessageConverter(MessageType.JSON);
	}
}
