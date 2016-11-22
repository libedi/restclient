package com.kakaobank.auth.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * 휴대폰 확인 응답 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MobileAuthResponseDto extends ErrorResponse {
	private String validationId;		// 휴대폰 본인확인 거래번호
	private String code;				// 응답코드
	private String vendorCode;			// 통신사코드
	private String phoneNumber;			// 휴대폰번호
	private String birthdayAndGender;	// 주민번호 앞 7자리
	private String name;				// 고객명
	private String ci;					// CI번호
	private Long failCount;				// 비밀번호 오류횟수
	private Long phoneNumberFailCount;
	
	public String getValidationId() {
		return validationId;
	}
	public void setValidationId(String validationId) {
		this.validationId = validationId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBirthdayAndGender() {
		return birthdayAndGender;
	}
	public void setBirthdayAndGender(String birthdayAndGender) {
		this.birthdayAndGender = birthdayAndGender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public Long getFailCount() {
		return failCount;
	}
	public void setFailCount(Long failCount) {
		this.failCount = failCount;
	}
	public Long getPhoneNumberFailCount() {
		return phoneNumberFailCount;
	}
	public void setPhoneNumberFailCount(Long phoneNumberFailCount) {
		this.phoneNumberFailCount = phoneNumberFailCount;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileAuthResponseDto{\"validationId\"=\"").append(validationId).append("\", \"code\"=\"")
				.append(code).append("\", \"vendorCode\"=\"").append(vendorCode).append("\", \"phoneNumber\"=\"")
				.append(phoneNumber).append("\", \"birthdayAndGender\"=\"").append(birthdayAndGender)
				.append("\", \"name\"=\"").append(name).append("\", \"ci\"=\"").append(ci)
				.append("\", \"failCount\"=\"").append(failCount).append("\", \"phoneNumberFailCount\"=\"")
				.append(phoneNumberFailCount).append("\", \"timestamp\"=\"").append(timestamp)
				.append("\", \"status\"=\"").append(status).append("\", \"exception\"=\"").append(exception)
				.append("\", \"message\"=\"").append(message).append("\", \"error\"=\"").append(error)
				.append("\", \"path\"=\"").append(path).append("\", \"errors\"=\"").append(errors).append("\"}");
		return builder.toString();
	}
}
