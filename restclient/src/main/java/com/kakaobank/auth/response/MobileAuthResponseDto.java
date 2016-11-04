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
	private String validationId;	// 휴대폰 본인확인 거래번호
	private String code;			// 응답코드
	private Long failCount;		// 비밀번호 오류횟수
	private Long userFailCount;
	
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
	public Long getFailCount() {
		return failCount;
	}
	public void setFailCount(Long failCount) {
		this.failCount = failCount;
	}
	public Long getUserFailCount() {
		return userFailCount;
	}
	public void setUserFailCount(Long userFailCount) {
		this.userFailCount = userFailCount;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileAuthResponseDto{\"validationId\"=\"").append(validationId).append("\", \"code\"=\"")
				.append(code).append("\", \"failCount\"=\"").append(failCount).append("\", \"userFailCount\"=\"")
				.append(userFailCount).append("\", \"timestamp\"=\"").append(timestamp).append("\", \"status\"=\"")
				.append(status).append("\", \"exception\"=\"").append(exception).append("\", \"message\"=\"")
				.append(message).append("\", \"error\"=\"").append(error).append("\", \"path\"=\"").append(path)
				.append("\", \"errors\"=\"").append(errors).append("\"}");
		return builder.toString();
	}
	
}
