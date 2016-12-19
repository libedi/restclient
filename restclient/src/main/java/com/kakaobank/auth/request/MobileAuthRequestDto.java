package com.kakaobank.auth.request;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kakaobank.restclient.convert.MessageConverterFactory;
import com.kakaobank.restclient.convert.MessageType;

/**
 * 비회원 휴대폰 확인 요청 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MobileAuthRequestDto extends EncryptedRequest {
	@JsonIgnore
	private final String REQUEST_PATH = "/api/v1/authentications/mobile";

	@NotEmpty
	@Pattern(regexp="^0[1-6]$")
	@Size(min=2, max=2)
	protected String vendorCode;			// 통신사 코드 (01:SKT, 02:KT, 03:LGU, 04:SKTMVNO, 05:KTMVNO, 06:LGUMVNO)
	@NotEmpty
	protected String phoneNumber;			// E2E 암호화 된 휴대폰 번호
	@NotEmpty
	protected String name;					// E2E 암호화 된 고객명
	@NotEmpty
	protected String birthdayAndGender;	// E2E 암호화 된 생년월일 8자리 + 성별코드 1자리 (190012311)
	
	public MobileAuthRequestDto() {
		this.makeDefaultHeader();
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
	@Override
	public String getRequestPath() {
		return this.REQUEST_PATH;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileAuthRequestDto{\"vendorCode\"=\"").append(vendorCode).append("\", \"phoneNumber\"=\"")
				.append(phoneNumber).append("\", \"name\"=\"").append(name).append("\", \"birthdayAndGender\"=\"")
				.append(birthdayAndGender).append("\", \"e2eId\"=\"").append(e2eId).append("\"}");
		return builder.toString();
	}
	@Override
	protected void setMessageConverter() {
		this.messageConverter = MessageConverterFactory.createMessageConverter(MessageType.JSON);
	}
}
