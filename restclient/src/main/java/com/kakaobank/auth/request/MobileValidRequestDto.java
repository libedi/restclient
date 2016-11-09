package com.kakaobank.auth.request;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kakaobank.restclient.convert.JsonStringMessageConverter;
import com.kakaobank.restclient.request.RestPostRequest;

/**
 * 비회원 휴대폰 확인 검증 요청 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MobileValidRequestDto extends RestPostRequest {
	@JsonIgnore
	private final String REQUEST_PATH = "/api/v1/authentication/mobile/";
	
	@NotEmpty
	protected String validationId;		// 휴대폰 본인확인 거래번호
	@NotEmpty
	protected String arthNo;			// SMS 인증번호
	@NotEmpty
	protected String guid;				// GUID
	
	public MobileValidRequestDto() {
		this.messageConverter = new JsonStringMessageConverter();
		this.guid = this.makeGuid();
	}
	
	public String getValidationId() {
		return validationId;
	}
	public void setValidationId(String validationId) {
		this.validationId = validationId;
	}
	public String getArthNo() {
		return arthNo;
	}
	public void setArthNo(String arthNo) {
		this.arthNo = arthNo;
	}
	@Override
	public String getRequestPath() {
		return new StringBuilder().append(this.REQUEST_PATH).append(this.validationId).toString();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileValidRequestDto{\"validationId\"=\"").append(validationId).append("\", \"arthNo\"=\"")
				.append(arthNo).append("\", \"guid\"=\"").append(guid).append("\"}");
		return builder.toString();
	}

	protected String makeGuid(){
		return new StringBuilder()
				.append("037CCSTMA039D")
				.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()))
				.append(String.format("%06d", (int) (Math.random() * 1000000)))
				.append("001")
				.toString();
	}
	
}
