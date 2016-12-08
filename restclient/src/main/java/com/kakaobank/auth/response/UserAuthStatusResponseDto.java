package com.kakaobank.auth.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * 사용자 인증 상태 조회 응답 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserAuthStatusResponseDto extends ErrorResponse {
	private String code;
	private UserAuthStatusResponseDetailDto pin;
	private UserAuthStatusResponseDetailDto pattern;
	private UserAuthStatusResponseDetailDto fingerprint;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public UserAuthStatusResponseDetailDto getPin() {
		return pin;
	}
	public void setPin(UserAuthStatusResponseDetailDto pin) {
		this.pin = pin;
	}
	public UserAuthStatusResponseDetailDto getPattern() {
		return pattern;
	}
	public void setPattern(UserAuthStatusResponseDetailDto pattern) {
		this.pattern = pattern;
	}
	public UserAuthStatusResponseDetailDto getFingerprint() {
		return fingerprint;
	}
	public void setFingerprint(UserAuthStatusResponseDetailDto fingerprint) {
		this.fingerprint = fingerprint;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserAuthStatusResponseDto{\"code\"=\"").append(code).append("\", \"pin\"=\"").append(pin)
				.append("\", \"pattern\"=\"").append(pattern).append("\", \"fingerprint\"=\"").append(fingerprint)
				.append("\", \"timestamp\"=\"").append(timestamp).append("\", \"status\"=\"").append(status)
				.append("\", \"exception\"=\"").append(exception).append("\", \"message\"=\"").append(message)
				.append("\", \"error\"=\"").append(error).append("\", \"path\"=\"").append(path)
				.append("\", \"deviceBlocked\"=\"").append(deviceBlocked).append("\", \"errors\"=\"").append(errors)
				.append("\"}");
		return builder.toString();
	}
}
