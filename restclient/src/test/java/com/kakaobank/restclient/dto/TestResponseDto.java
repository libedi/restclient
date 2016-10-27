package com.kakaobank.restclient.dto;

public class TestResponseDto {
	private String e2eId;
	private String public_key;
	
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
		builder.append("TestResponseDto{\"e2eId\"=\"").append(e2eId).append("\", \"public_key\"=\"").append(public_key)
				.append("\"}");
		return builder.toString();
	}
	
}
