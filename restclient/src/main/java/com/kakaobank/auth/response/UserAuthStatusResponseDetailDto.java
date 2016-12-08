package com.kakaobank.auth.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * 사용자 인증 상태 조회 응답 상세 DTO
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserAuthStatusResponseDetailDto extends ErrorResponse {
	private Integer failCount;
	private Integer secondsToBeActive;
	private String blockedAt;
	
	public Integer getFailCount() {
		return failCount;
	}
	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}
	public Integer getSecondsToBeActive() {
		return secondsToBeActive;
	}
	public void setSecondsToBeActive(Integer secondsToBeActive) {
		this.secondsToBeActive = secondsToBeActive;
	}
	public String getBlockedAt() {
		return blockedAt;
	}
	public void setBlockedAt(String blockedAt) {
		this.blockedAt = blockedAt;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserAuthStatusResponseDetailDto{\"failCount\"=\"").append(failCount)
				.append("\", \"secondsToBeActive\"=\"").append(secondsToBeActive).append("\", \"blockedAt\"=\"")
				.append(blockedAt).append("\", \"timestamp\"=\"").append(timestamp).append("\", \"status\"=\"")
				.append(status).append("\", \"exception\"=\"").append(exception).append("\", \"message\"=\"")
				.append(message).append("\", \"error\"=\"").append(error).append("\", \"path\"=\"").append(path)
				.append("\", \"deviceBlocked\"=\"").append(deviceBlocked).append("\", \"errors\"=\"").append(errors)
				.append("\"}");
		return builder.toString();
	}
	
}
