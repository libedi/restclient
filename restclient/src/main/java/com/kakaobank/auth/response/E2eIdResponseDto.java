package com.kakaobank.auth.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.kakaobank.stamp.e2e.E2eEncryptor;

/**
 * 인증 키 응답 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
public class E2eIdResponseDto extends ErrorResponse {
	private String e2e_id;				// E2E ID : Stamp 서버에서 발행되는 Key
	private String server_public_key;	// 공개키 : Stamp 서버에서 생성한 공개키
	private String code;
	@JsonIgnore
	private E2eEncryptor e2eEncryptor;
	
	public String getE2e_id() {
		return e2e_id;
	}
	public void setE2e_id(String e2e_id) {
		this.e2e_id = e2e_id;
	}
	public String getServer_public_key() {
		return server_public_key;
	}
	public void setServer_public_key(String server_public_key) {
		this.server_public_key = server_public_key;
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
		builder.append("E2eIdResponseDto{\"e2e_id\"=\"").append(e2e_id).append("\", \"server_public_key\"=\"")
				.append(server_public_key).append("\", \"code\"=\"").append(code).append("\", \"timestamp\"=\"")
				.append(timestamp).append("\", \"status\"=\"").append(status).append("\", \"exception\"=\"")
				.append(exception).append("\", \"message\"=\"").append(message).append("\", \"error\"=\"").append(error)
				.append("\", \"path\"=\"").append(path).append("\"}");
		return builder.toString();
	}
	
}
