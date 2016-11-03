package com.kakaobank.auth.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 휴대폰 확인 응답 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
public class MobileAuthResponseDto extends ErrorResponse {
	private String validation_id;	// 휴대폰 본인확인 거래번호
	private String code;			// 응답코드
	private Long fail_count;		// 비밀번호 오류횟수
	private Long user_fail_count;
	
	public String getValidation_id() {
		return validation_id;
	}
	public void setValidation_id(String validation_id) {
		this.validation_id = validation_id;
	}
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
	public Long getUser_fail_count() {
		return user_fail_count;
	}
	public void setUser_fail_count(Long user_fail_count) {
		this.user_fail_count = user_fail_count;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileAuthResponseDto{\"validation_id\"=\"").append(validation_id).append("\", \"code\"=\"")
				.append(code).append("\", \"fail_count\"=\"").append(fail_count).append("\", \"user_fail_count\"=\"")
				.append(user_fail_count).append("\", \"timestamp\"=\"").append(timestamp).append("\", \"status\"=\"")
				.append(status).append("\", \"exception\"=\"").append(exception).append("\", \"message\"=\"")
				.append(message).append("\", \"error\"=\"").append(error).append("\", \"path\"=\"").append(path)
				.append("\", \"errors\"=\"").append(errors).append("\"}");
		return builder.toString();
	}
}
