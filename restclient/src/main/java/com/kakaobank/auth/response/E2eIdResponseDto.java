package com.kakaobank.auth.response;

/**
 * 인증 키 응답 DTO
 * @author 박상준
 *
 */
public class E2eIdResponseDto {
	private String e2eId;		// E2E ID : Stamp 서버에서 발행되는 Key
	private String public_key;	// 공개키 : Stamp 서버에서 생성한 공개키
	
	public String getE2eId() {
		return e2eId;
	}
	public void setE2eId(String e2eId) {
		this.e2eId = e2eId;
	}
	public String getPublic_key() {
		return public_key;
	}
	public void setPublic_key(String public_key) {
		this.public_key = public_key;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("E2eIdResponseDto{\"e2eId\"=\"").append(e2eId).append("\", \"public_key\"=\"").append(public_key)
				.append("\"}");
		return builder.toString();
	}
	
}
