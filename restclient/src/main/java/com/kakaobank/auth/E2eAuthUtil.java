package com.kakaobank.auth;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.kakaobank.auth.request.E2eIdRequestDto;
import com.kakaobank.auth.request.EncryptedRequest;
import com.kakaobank.auth.request.MobileAuthRequestDto;
import com.kakaobank.auth.request.MobileValidRequestDto;
import com.kakaobank.auth.request.PinAuthRequestDto;
import com.kakaobank.auth.response.E2eIdResponseDto;
import com.kakaobank.auth.response.MobileAuthResponseDto;
import com.kakaobank.auth.response.MobileValidResponseDto;
import com.kakaobank.auth.response.PinAuthResponseDto;
import com.kakaobank.restclient.RestClient;
import com.kakaobank.restclient.response.RestResponse;
import com.kakaobank.stamp.e2e.E2eEncryptor;

/**
 * E2E 인증 관련 Util
 * @author 박상준
 *
 */
public class E2eAuthUtil {
	private RestClient restClient;
	public void setRestClient(RestClient restClient) {
		this.restClient = restClient;
	}
	
	/**
	 * E2E ID 조회
	 * 
	 * @param requestDto
	 * @return E2eIdResponseDto
	 * @throws Exception
	 */
	public E2eIdResponseDto getE2eId(E2eIdRequestDto requestDto) throws Exception {
		E2eEncryptor e2e = new E2eEncryptor();
		requestDto.setPublic_key(e2e.getCsPublicKey());
		
		RestResponse<E2eIdResponseDto> resp = this.restClient.exchange(requestDto, E2eIdResponseDto.class);
		E2eIdResponseDto result = null;
		if(resp.has200StatusCode()){
			result = resp.getContent();
			result.setE2eEncryptor(e2e);
		}
		return result;
	}
	
	/**
	 * PIN / 해제코드 인증 요청
	 * 
	 * @param e2eIdResponseDto
	 * @param pinAuthRequestDto
	 * @return PinAuthResponseDto
	 * @throws Exception
	 */
	public PinAuthResponseDto requestPinNumberAuthentication(E2eIdResponseDto e2eIdResponseDto, PinAuthRequestDto pinAuthRequestDto)
			throws Exception{
		
		E2eEncryptor e2e = e2eIdResponseDto.getE2eEncryptor();
		e2e.setStampPublicKey(e2eIdResponseDto.getServer_public_key());
		e2e.setE2eId(e2eIdResponseDto.getE2e_id());
		// 데이터 암호화
		pinAuthRequestDto.setValue(e2e.encryptMessage(pinAuthRequestDto.getPinNum()));
		// 인증요청
		return this.requestEncryptedData(e2eIdResponseDto, pinAuthRequestDto, PinAuthResponseDto.class);
	}
	
	/**
	 * 휴대폰 확인 요청
	 * 
	 * @param e2eIdResponseDto
	 * @param mobileAuthRequestDto
	 * @return MobileAuthResponseDto
	 * @throws Exception 
	 */
	public MobileAuthResponseDto requestMobileAuthentication(E2eIdResponseDto e2eIdResponseDto, MobileAuthRequestDto mobileAuthRequestDto)
			throws Exception{
		
		E2eEncryptor e2e = e2eIdResponseDto.getE2eEncryptor();
		e2e.setStampPublicKey(e2eIdResponseDto.getServer_public_key());
		e2e.setE2eId(e2eIdResponseDto.getE2e_id());
		// 데이터 암호화
		mobileAuthRequestDto.setPhoneNumber(e2e.encryptMessage(mobileAuthRequestDto.getPhoneNumber()));
		mobileAuthRequestDto.setName(e2e.encryptMessage(mobileAuthRequestDto.getName()));
		mobileAuthRequestDto.setBirthDay(e2e.encryptMessage(mobileAuthRequestDto.getBirthDay()));
		// 인증요청
		return this.requestEncryptedData(e2eIdResponseDto, mobileAuthRequestDto, MobileAuthResponseDto.class);
	}
	
	/**
	 * 휴대폰 검증 요청
	 * 
	 * @param mobileValidRequestDto
	 * @return MobileValidResponseDto
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public MobileValidResponseDto requestMobileValidataion(MobileValidRequestDto mobileValidRequestDto) throws ClientProtocolException, IOException{
		RestResponse<MobileValidResponseDto> resp = this.restClient.exchange(mobileValidRequestDto, MobileValidResponseDto.class);
		MobileValidResponseDto result = null;
		if(resp.has200StatusCode()){
			result = resp.getContent();
		}
		return result;
	}
	
	/**
	 * 암호화 데이터 인증 요청
	 * 
	 * @param e2eIdResponseDto
	 * @param encryptedRequest
	 * @param clazz
	 * @return T
	 * @throws Exception
	 */
	private <T> T requestEncryptedData(E2eIdResponseDto e2eIdResponseDto, EncryptedRequest encryptedRequest, Class<T> clazz) throws Exception{
		encryptedRequest.setE2e_id(e2eIdResponseDto.getE2e_id());
		RestResponse<T> resp = this.restClient.exchange(encryptedRequest, clazz);
		T result = null;
		if(resp.has200StatusCode()){
			result = resp.getContent();
		}
		return result;
	}
	
}
