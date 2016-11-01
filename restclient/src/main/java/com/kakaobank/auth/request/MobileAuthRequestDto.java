package com.kakaobank.auth.request;

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

	protected String VenderCode;		// 통신사 코드 (01:SKT, 02:KT, 03:LGU, 04:SKTMVNO, 05:KTMVNO, 06:LGUMVNO)
	protected String PhoneNumber;		// E2E 암호화 된 휴대폰 번호
	protected String Name;				// E2E 암호화 된 고객명
	protected String BirthDay;			// E2E 암호화 된 생년월일 8자리 (19001231)
	
	public MobileAuthRequestDto() {
		this.messageConverter = new JsonStringMessageConverter();
	}
	
	public String getVenderCode() {
		return VenderCode;
	}
	public void setVenderCode(String venderCode) {
		VenderCode = venderCode;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getBirthDay() {
		return BirthDay;
	}
	public void setBirthDay(String birthDay) {
		BirthDay = birthDay;
	}
	@Override
	public String getRequestPath() {
		return this.REQUEST_PATH;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileAuthRequestDto{\"VenderCode\"=\"").append(VenderCode).append("\", \"PhoneNumber\"=\"")
				.append(PhoneNumber).append("\", \"Name\"=\"").append(Name).append("\", \"BirthDay\"=\"")
				.append(BirthDay).append("\", \"e2e_id\"=\"").append(e2e_id).append("\"}");
		return builder.toString();
	}

}
