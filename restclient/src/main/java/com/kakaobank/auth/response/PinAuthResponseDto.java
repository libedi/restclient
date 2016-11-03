package com.kakaobank.auth.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * PIN / 해제번호 인증 응답 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
public class PinAuthResponseDto extends ErrorResponse {
	private String code;		// 응답코드
	private Long fail_count;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getFail_count() {
		return fail_count;
	}
	public void setFail_count(Long fail_count) {
		this.fail_count = fail_count;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PinAuthResponseDto{\"code\"=\"").append(code).append("\", \"fail_count\"=\"").append(fail_count)
				.append("\", \"timestamp\"=\"").append(timestamp).append("\", \"status\"=\"").append(status)
				.append("\", \"exception\"=\"").append(exception).append("\", \"message\"=\"").append(message)
				.append("\", \"error\"=\"").append(error).append("\", \"path\"=\"").append(path)
				.append("\", \"errors\"=\"").append(errors).append("\"}");
		return builder.toString();
	}
}
