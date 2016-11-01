package com.kakaobank.auth.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 휴대폰 확인 검증 응답 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
public class MobileValidResponseDto extends ErrorResponse {
	private String code;			// 휴대폰 본인확인 거래번호
	private String vender_code;		// 통신사 코드 (01:SKT, 02:KT, 03:LGU, 04:SKTMVNO, 05:KTMVNO, 06:LGUMVNO) 
	private String phone_number;		// 후대폰 번호
	private String ciNo;			// CI
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getVender_code() {
		return vender_code;
	}
	public void setVender_code(String vender_code) {
		this.vender_code = vender_code;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getCiNo() {
		return ciNo;
	}
	public void setCiNo(String ciNo) {
		this.ciNo = ciNo;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileValidResponseDto{\"code\"=\"").append(code).append("\", \"vender_code\"=\"")
				.append(vender_code).append("\", \"phone_number\"=\"").append(phone_number).append("\", \"ciNo\"=\"")
				.append(ciNo).append("\", \"timestamp\"=\"").append(timestamp).append("\", \"status\"=\"")
				.append(status).append("\", \"exception\"=\"").append(exception).append("\", \"message\"=\"")
				.append(message).append("\", \"error\"=\"").append(error).append("\", \"path\"=\"").append(path)
				.append("\", \"errors\"=\"").append(errors).append("\"}");
		return builder.toString();
	}
	
}
