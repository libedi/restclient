package com.kakaobank.auth.response;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	private String code;				// 응답코드
	private String validationId;		// 휴대폰 본인확인 거래번호
	private String vendorCode;			// 통신사 코드 (01:SKT, 02:KT, 03:LGU, 04:SKTMVNO, 05:KTMVNO, 06:LGUMVNO) 
	private String phoneNumber;			// 휴대폰 번호
	private String name;				// 고객명
	private String birthdayAndGender;	// 주민번호 앞 7자리
	private String ci;					// CI 번호
	private String failCount;			// 실패횟수
	private String phoneNumberFailCount; 
	private String authDate;			// 화면으로 넘겨줄 인증날짜
	private String authTime;			// 화면으로 넘겨줄 인증시간
	private Boolean isEqualsCiNo;		// 사용자 CI번호와 인증 CI번호 비교 결과
	
	public MobileValidResponseDto() {
		Date current = new Date();
		this.authDate = new SimpleDateFormat("yyyyMMdd").format(current);
		this.authTime = new SimpleDateFormat("HHmmss").format(current);
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValidationId() {
		return validationId;
	}
	public void setValidationId(String validationId) {
		this.validationId = validationId;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthdayAndGender() {
		return birthdayAndGender;
	}
	public void setBirthdayAndGender(String birthdayAndGender) {
		this.birthdayAndGender = birthdayAndGender;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getFailCount() {
		return failCount;
	}
	public void setFailCount(String failCount) {
		this.failCount = failCount;
	}
	public String getPhoneNumberFailCount() {
		return phoneNumberFailCount;
	}
	public void setPhoneNumberFailCount(String phoneNumberFailCount) {
		this.phoneNumberFailCount = phoneNumberFailCount;
	}
	public String getAuthDate() {
		return authDate;
	}
	public void setAuthDate(String authDate) {
		this.authDate = authDate;
	}
	public String getAuthTime() {
		return authTime;
	}
	public void setAuthTime(String authTime) {
		this.authTime = authTime;
	}
	public Boolean getIsEqualsCiNo() {
		return isEqualsCiNo;
	}
	public void setIsEqualsCiNo(Boolean isEqualsCiNo) {
		this.isEqualsCiNo = isEqualsCiNo;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileValidResponseDto{\"code\"=\"").append(code).append("\", \"validationId\"=\"")
				.append(validationId).append("\", \"vendorCode\"=\"").append(vendorCode)
				.append("\", \"phoneNumber\"=\"").append(phoneNumber).append("\", \"name\"=\"").append(name)
				.append("\", \"birthdayAndGender\"=\"").append(birthdayAndGender).append("\", \"ci\"=\"").append(ci)
				.append("\", \"failCount\"=\"").append(failCount).append("\", \"phoneNumberFailCount\"=\"")
				.append(phoneNumberFailCount).append("\", \"authDate\"=\"").append(authDate)
				.append("\", \"authTime\"=\"").append(authTime).append("\", \"isEqualsCiNo\"=\"").append(isEqualsCiNo)
				.append("\", \"timestamp\"=\"").append(timestamp).append("\", \"status\"=\"").append(status)
				.append("\", \"exception\"=\"").append(exception).append("\", \"message\"=\"").append(message)
				.append("\", \"error\"=\"").append(error).append("\", \"path\"=\"").append(path)
				.append("\", \"deviceBlocked\"=\"").append(deviceBlocked).append("\", \"errors\"=\"").append(errors)
				.append("\"}");
		return builder.toString();
	}
}
