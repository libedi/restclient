package com.kakaobank.auth.response;

/**
 * PIN / 해제번호 인증 응답 DTO
 * @author 박상준
 *
 */
public class PinAuthResponseDto {
	private String Code;		// 응답코드
	private String Message;		// 에러메시지
	private int ErrCount;		// 비밀번호 오류횟수
	
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public int getErrCount() {
		return ErrCount;
	}
	public void setErrCount(int errCount) {
		ErrCount = errCount;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PinAuthResponseDto{\"Code\"=\"").append(Code).append("\", \"Message\"=\"").append(Message)
				.append("\", \"ErrCount\"=\"").append(ErrCount).append("\"}");
		return builder.toString();
	}
	
}
