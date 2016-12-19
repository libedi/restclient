package com.kakaobank.auth.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kakaobank.restclient.convert.JsonStringMessageConverter;
import com.kakaobank.restclient.convert.MessageConverterFactory;
import com.kakaobank.restclient.convert.MessageType;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UnlockAuthRequestDto extends EncryptedRequest {
	public enum ProcessInfo {
		signing		// 거래인증 프로세스
		, unlock	// 기기잠금 프로세스
		;
	}
	
	@JsonIgnore
	private final String REQUEST_PATH = "/api/v1/authentications/unlockcode/";
	
	@NotEmpty
	private String userId;				// 사용자관리번호
	@NotEmpty
	private String unlockCode;			// 해제코드
	@NotNull
	private ProcessInfo processInfo;	// 프로세스 타입
	
	public UnlockAuthRequestDto(){
		this.makeDefaultHeader();
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUnlockCode() {
		return unlockCode;
	}
	public void setUnlockCode(String unlockCode) {
		this.unlockCode = unlockCode;
	}
	public ProcessInfo getProcessInfo() {
		return processInfo;
	}
	public void setProcessInfo(ProcessInfo processInfo) {
		this.processInfo = processInfo;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UnlockAuthRequestDto{\"userId\"=\"").append(userId).append("\", \"unlockCode\"=\"")
				.append(unlockCode).append("\", \"processInfo\"=\"").append(processInfo).append("\", \"e2eId\"=\"")
				.append(e2eId).append("\"}");
		return builder.toString();
	}
	@Override
	public String getRequestPath() {
		return new StringBuilder().append(this.REQUEST_PATH).append(this.userId).toString();
	}

	@Override
	protected void setMessageConverter() {
		this.messageConverter = MessageConverterFactory.createMessageConverter(MessageType.JSON);
	}
}
