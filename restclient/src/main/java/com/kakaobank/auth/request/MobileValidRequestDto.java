package com.kakaobank.auth.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.kakaobank.restclient.convert.JsonStringMessageConverter;
import com.kakaobank.restclient.request.RestPostRequest;

/**
 * 비회원 휴대폰 확인 검증 요청 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
public class MobileValidRequestDto extends RestPostRequest {
	private final String REQUEST_PATH = "/api/v1/authentication/mobile/";
	
	protected String validation_id;		// 휴대폰 본인확인 거래번호
	protected String arth_no;			// SMS 인증번호
	
	public MobileValidRequestDto() {
		this.messageConverter = new JsonStringMessageConverter();
	}
	
	public String getValidation_id() {
		return validation_id;
	}
	public void setValidation_id(String validation_id) {
		this.validation_id = validation_id;
	}
	public String getArth_no() {
		return arth_no;
	}
	public void setArth_no(String arth_no) {
		this.arth_no = arth_no;
	}
	@Override
	public String getRequestPath() {
		return new StringBuilder().append(this.REQUEST_PATH).append(this.validation_id).toString();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileValidRequestDto{\"validation_id\"=\"").append(validation_id).append("\", \"arth_no\"=\"")
				.append(arth_no).append("\"}");
		return builder.toString();
	}
	
}
