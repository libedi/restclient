package com.kakaobank.auth.request;

import com.kakaobank.restclient.convert.JsonStringMessageConverter;
import com.kakaobank.restclient.request.RestPostRequest;

/**
 * 비회원 휴대폰 확인 검증 요청 DTO
 * @author 박상준
 *
 */
public class MobileValidRequestDto extends RestPostRequest {
	private final String REQUEST_PATH = "/api/v1/authentication/mobile/";
	
	protected String ValidationID;		// 휴대폰 본인확인 거래번호
	protected String ArthNo;			// SMS 인증번호
	
	public MobileValidRequestDto() {
		this.messageConverter = new JsonStringMessageConverter();
	}
	
	public String getValidationID() {
		return ValidationID;
	}
	public void setValidationID(String validationID) {
		ValidationID = validationID;
	}
	public String getArthNo() {
		return ArthNo;
	}
	public void setArthNo(String arthNo) {
		ArthNo = arthNo;
	}
	@Override
	public String getRequestPath() {
		return new StringBuilder().append(this.REQUEST_PATH).append(this.ValidationID).toString();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileValidRequestDto{\"ValidationID\"=\"").append(ValidationID).append("\", \"ArthNo\"=\"")
				.append(ArthNo).append("\"}");
		return builder.toString();
	}
	
}
