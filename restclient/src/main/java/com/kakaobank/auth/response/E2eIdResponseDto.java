package com.kakaobank.auth.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kakaobank.stamp.e2e.E2eEncryptor;

/**
 * 인증 키 응답 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class E2eIdResponseDto extends ErrorResponse {
	private String e2eId;				// E2E ID : Stamp 서버에서 발행되는 Key
	private String serverPublicKey;	// 공개키 : Stamp 서버에서 생성한 공개키
	private String code;
	@JsonIgnore
	private E2eEncryptor e2eEncryptor;
	
	public String getE2eId() {
		return e2eId;
	}
	public void setE2eId(String e2eId) {
		this.e2eId = e2eId;
	}
	public String getServerPublicKey() {
		return serverPublicKey;
	}
	public void setServerPublicKey(String serverPublicKey) {
		this.serverPublicKey = serverPublicKey;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public E2eEncryptor getE2eEncryptor() {
		return e2eEncryptor;
	}
	public void setE2eEncryptor(E2eEncryptor e2eEncryptor) {
		this.e2eEncryptor = e2eEncryptor;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("E2eIdResponseDto{\"e2eId\"=\"").append(e2eId).append("\", \"serverPublicKey\"=\"")
				.append(serverPublicKey).append("\", \"code\"=\"").append(code).append("\", \"e2eEncryptor\"=\"")
				.append(e2eEncryptor).append("\", \"timestamp\"=\"").append(timestamp).append("\", \"status\"=\"")
				.append(status).append("\", \"exception\"=\"").append(exception).append("\", \"message\"=\"")
				.append(message).append("\", \"error\"=\"").append(error).append("\", \"path\"=\"").append(path)
				.append("\", \"errors\"=\"").append(errors).append("\"}");
		return builder.toString();
	}
	
}
