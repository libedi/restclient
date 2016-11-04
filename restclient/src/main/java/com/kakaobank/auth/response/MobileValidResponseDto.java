package com.kakaobank.auth.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * 휴대폰 확인 검증 응답 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MobileValidResponseDto extends ErrorResponse {
	private String code;			// 휴대폰 본인확인 거래번호
	private String venderCode;		// 통신사 코드 (01:SKT, 02:KT, 03:LGU, 04:SKTMVNO, 05:KTMVNO, 06:LGUMVNO) 
	private String phoneNumber;		// 후대폰 번호
	private String ci;				// CI
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getVenderCode() {
		return venderCode;
	}
	public void setVenderCode(String venderCode) {
		this.venderCode = venderCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileValidResponseDto{\"code\"=\"").append(code).append("\", \"venderCode\"=\"")
				.append(venderCode).append("\", \"phoneNumber\"=\"").append(phoneNumber).append("\", \"ci\"=\"")
				.append(ci).append("\", \"timestamp\"=\"").append(timestamp).append("\", \"status\"=\"").append(status)
				.append("\", \"exception\"=\"").append(exception).append("\", \"message\"=\"").append(message)
				.append("\", \"error\"=\"").append(error).append("\", \"path\"=\"").append(path)
				.append("\", \"errors\"=\"").append(errors).append("\"}");
		return builder.toString();
	}
	
}
