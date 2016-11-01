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
	private Integer errCount;		// 비밀번호 오류횟수
	
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
	public Integer getErrCount() {
		return errCount;
	}
	public void setErrCount(Integer errCount) {
		this.errCount = errCount;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileAuthResponseDto{\"validation_id\"=\"").append(validation_id).append("\", \"code\"=\"")
				.append(code).append("\", \"errCount\"=\"").append(errCount).append("\", \"timestamp\"=\"")
				.append(timestamp).append("\", \"status\"=\"").append(status).append("\", \"exception\"=\"")
				.append(exception).append("\", \"message\"=\"").append(message).append("\", \"error\"=\"").append(error)
				.append("\", \"path\"=\"").append(path).append("\", \"errors\"=\"").append(errors).append("\"}");
		return builder.toString();
	}
	
}
