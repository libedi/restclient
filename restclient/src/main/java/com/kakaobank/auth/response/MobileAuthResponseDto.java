package com.kakaobank.auth.response;

/**
 * 휴대폰 확인 응답 DTO
 * @author 박상준
 *
 */
public class MobileAuthResponseDto {
	private String ValidationID;	// 휴대폰 본인확인 거래번호
	private String Code;			// 응답코드
	private String Message;			// 에러메시지
	private int ErrCount;			// 비밀번호 오류횟수
	
	public String getValidationID() {
		return ValidationID;
	}
	public void setValidationID(String validationID) {
		ValidationID = validationID;
	}
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
		builder.append("MobileAuthResponseDto{\"ValidationID\"=\"").append(ValidationID).append("\", \"Code\"=\"")
				.append(Code).append("\", \"Message\"=\"").append(Message).append("\", \"ErrCount\"=\"")
				.append(ErrCount).append("\"}");
		return builder.toString();
	}
	
}
