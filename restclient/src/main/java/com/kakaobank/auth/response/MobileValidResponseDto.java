package com.kakaobank.auth.response;

/**
 * 휴대폰 확인 검증 응답 DTO
 * @author 박상준
 *
 */
public class MobileValidResponseDto {
	private String Code;			// 휴대폰 본인확인 거래번호
	private String Message;			// 응답코드
	private String VenderCode;		// 통신사 코드 (01:SKT, 02:KT, 03:LGU, 04:SKTMVNO, 05:KTMVNO, 06:LGUMVNO) 
	private String PhoneNumber;		// 후대폰 번호
	private String CiNo;			// CI
	
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
	public String getVenderCode() {
		return VenderCode;
	}
	public void setVenderCode(String venderCode) {
		VenderCode = venderCode;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getCiNo() {
		return CiNo;
	}
	public void setCiNo(String ciNo) {
		CiNo = ciNo;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileValidResponseDto{\"Code\"=\"").append(Code).append("\", \"Message\"=\"").append(Message)
				.append("\", \"VenderCode\"=\"").append(VenderCode).append("\", \"PhoneNumber\"=\"").append(PhoneNumber)
				.append("\", \"CiNo\"=\"").append(CiNo).append("\"}");
		return builder.toString();
	}
}
