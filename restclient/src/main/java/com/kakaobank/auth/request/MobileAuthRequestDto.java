package com.kakaobank.auth.request;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.kakaobank.restclient.convert.JsonStringMessageConverter;

/**
 * 비회원 휴대폰 확인 요청 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
public class MobileAuthRequestDto extends EncryptedRequest {
	@JsonIgnore
	private final String REQUEST_PATH = "/api/v1/authentications/mobile";

	@NotEmpty
	@Pattern(regexp="^0[1-6]$")
	protected String vendor_code;			// 통신사 코드 (01:SKT, 02:KT, 03:LGU, 04:SKTMVNO, 05:KTMVNO, 06:LGUMVNO)
	@NotEmpty
	protected String phone_number;			// E2E 암호화 된 휴대폰 번호
	@NotEmpty
	protected String name;					// E2E 암호화 된 고객명
	@NotEmpty
	protected String birthday_and_gender;	// E2E 암호화 된 생년월일 8자리 + 성별코드 1자리 (190012311)
	
	public MobileAuthRequestDto() {
		this.messageConverter = new JsonStringMessageConverter();
	}
	
	public String getVendor_code() {
		return vendor_code;
	}
	public void setVendor_code(String vendor_code) {
		this.vendor_code = vendor_code;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday_and_gender() {
		return birthday_and_gender;
	}
	public void setBirthday_and_gender(String birthday_and_gender) {
		this.birthday_and_gender = birthday_and_gender;
	}
	@Override
	public String getRequestPath() {
		return this.REQUEST_PATH;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileAuthRequestDto{\"vendor_code\"=\"").append(vendor_code).append("\", \"phone_number\"=\"")
				.append(phone_number).append("\", \"name\"=\"").append(name).append("\", \"birthday_and_gender\"=\"")
				.append(birthday_and_gender).append("\", \"e2e_id\"=\"").append(e2e_id).append("\"}");
		return builder.toString();
	}

}
