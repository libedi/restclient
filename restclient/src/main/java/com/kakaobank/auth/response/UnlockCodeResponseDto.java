package com.kakaobank.auth.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * 해제코드 응답 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UnlockCodeResponseDto extends ErrorResponse {
	private String code;		// 응답코드

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UnlockCodeResponseDto{\"code\"=\"").append(code).append("\", \"timestamp\"=\"")
				.append(timestamp).append("\", \"status\"=\"").append(status).append("\", \"exception\"=\"")
				.append(exception).append("\", \"message\"=\"").append(message).append("\", \"error\"=\"").append(error)
				.append("\", \"path\"=\"").append(path).append("\", \"errors\"=\"").append(errors).append("\"}");
		return builder.toString();
	}
	
}
