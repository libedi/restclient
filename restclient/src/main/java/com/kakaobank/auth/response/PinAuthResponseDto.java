package com.kakaobank.auth.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * PIN / 해제번호 인증 응답 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PinAuthResponseDto extends ErrorResponse {
	private String code;		// 응답코드
	private Long failCount;
	
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PinAuthResponseDto{\"code\"=\"").append(code).append("\", \"failCount\"=\"").append(failCount)
				.append("\", \"timestamp\"=\"").append(timestamp).append("\", \"status\"=\"").append(status)
				.append("\", \"exception\"=\"").append(exception).append("\", \"message\"=\"").append(message)
				.append("\", \"error\"=\"").append(error).append("\", \"path\"=\"").append(path)
				.append("\", \"errors\"=\"").append(errors).append("\"}");
		return builder.toString();
	}
}
