package com.kakaobank.auth.response;

import java.util.List;

/**
 * Stamp API 서버 오류 응답
 * @author 박상준
 *
 */
public abstract class ErrorResponse {
	protected String timestamp;
	protected String status;		// HTTP 상태코드
	protected String exception;		// Exception 명
	protected String message;		// 오류 메시지
	protected String error;			// HTTP 상태 메시지
	protected String path;			// 요청 URI 경로
	protected List<Object> errors;
	
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
	
}
