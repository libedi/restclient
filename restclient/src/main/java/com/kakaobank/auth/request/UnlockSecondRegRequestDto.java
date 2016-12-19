package com.kakaobank.auth.request;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kakaobank.restclient.convert.MessageConverterFactory;
import com.kakaobank.restclient.convert.MessageType;

/**
 * 해제코드 2차등록 요청 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UnlockSecondRegRequestDto extends EncryptedRequest {
	@JsonIgnore
	private final String REQUEST_PATH = "/api/v1/registrations/:userId/unlockcode/second";
	
	@NotEmpty
	private String userId;		// 사용자관리번호
	
	@NotEmpty
	private String unlockCode;	// E2E 암호화된 해제코드
	
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UnlockSecondRegRequestDto{\"userId\"=\"").append(userId).append("\", \"unlockCode\"=\"")
				.append(unlockCode).append("\", \"e2eId\"=\"").append(e2eId).append("\"}");
		return builder.toString();
	}
	@Override
	public String getRequestPath() {
		return this.REQUEST_PATH.replace(":userId", this.userId);
	}
	@Override
	protected void setMessageConverter() {
		this.messageConverter = MessageConverterFactory.createMessageConverter(MessageType.JSON);
	}

}
