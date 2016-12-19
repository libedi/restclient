package com.kakaobank.auth.request;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kakaobank.restclient.convert.MessageConverterFactory;
import com.kakaobank.restclient.convert.MessageType;

/**
 * OTP 해제코드 인증 요청 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OtpUnlockAuthRequestDto extends EncryptedRequest {
	@JsonIgnore
	private final String REQUEST_PATH = "/api/v1/authentications/otp_unlockcode/";
	
	@JsonIgnore
	@NotEmpty
	private String userId;
	@NotEmpty
	private String otpUnlockCode;
	
	public OtpUnlockAuthRequestDto(){
		this.makeDefaultHeader();
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOtpUnlockCode() {
		return otpUnlockCode;
	}
	public void setOtpUnlockCode(String otpUnlockCode) {
		this.otpUnlockCode = otpUnlockCode;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OtpUnlockAuthRequestDto{\"userId\"=\"").append(userId).append("\", \"otpUnlockCode\"=\"")
				.append(otpUnlockCode).append("\", \"e2eId\"=\"").append(e2eId).append("\"}");
		return builder.toString();
	}
	@Override
	public String getRequestPath() {
		return new StringBuilder().append(this.REQUEST_PATH).append(this.getUserId()).toString();
	}

	@Override
	protected void setMessageConverter() {
		this.messageConverter = MessageConverterFactory.createMessageConverter(MessageType.JSON);
	}
	
}
