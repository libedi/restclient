package com.kakaobank.auth.request;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kakaobank.restclient.convert.JsonStringMessageConverter;

/**
 * 비회원 휴대폰 확인 검증 요청 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MobileValidRequestDto extends EncryptedRequest {
	@JsonIgnore
	private final String REQUEST_PATH = "/api/v1/authentications/mobile/";
	
	@JsonIgnore
	protected String decryptedValidationId;		// 휴대폰 본인확인 거래번호
	@NotEmpty
	protected String validationId;				// 휴대폰 본인확인 거래번호
	@NotEmpty
	protected String arthNo;					// SMS 인증번호
	
	public MobileValidRequestDto() {
		this.messageConverter = new JsonStringMessageConverter();
		this.makeDefaultHeader();
	}
	
	public String getDecryptedValidationId() {
		return decryptedValidationId;
	}
	public void setDecryptedValidationId(String decryptedValidationId) {
		this.decryptedValidationId = decryptedValidationId;
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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileValidRequestDto{\"decryptedValidationId\"=\"").append(decryptedValidationId)
				.append("\", \"validationId\"=\"").append(validationId).append("\", \"arthNo\"=\"").append(arthNo)
				.append("\", \"e2eId\"=\"").append(e2eId).append("\"}");
		return builder.toString();
	}

	@Override
	public String getRequestPath() {
		return new StringBuilder().append(this.REQUEST_PATH).append(this.decryptedValidationId).toString();
	}
}
