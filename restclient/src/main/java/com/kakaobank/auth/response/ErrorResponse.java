package com.kakaobank.auth.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * Stamp API 서버 오류 응답
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public abstract class ErrorResponse {
	protected String timestamp;
	protected String status;		// HTTP 상태코드
	protected String exception;		// Exception 명
	protected String message;		// 오류 메시지
	protected String error;			// HTTP 상태 메시지
	protected String path;			// 요청 URI 경로
	protected Boolean deviceBlocked;
	protected List<ErrorResponseDetail> errors;		// 상세오류사항
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Boolean getDeviceBlocked() {
		return deviceBlocked;
	}
	public void setDeviceBlocked(Boolean deviceBlocked) {
		this.deviceBlocked = deviceBlocked;
	}
	public List<ErrorResponseDetail> getErrors() {
		return errors;
	}
	public void setErrors(List<ErrorResponseDetail> errors) {
		this.errors = errors;
	}
}
