package com.kakaobank.restclient;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.kakaobank.auth.E2eAuthUtil;
import com.kakaobank.auth.request.E2eIdRequestDto;
import com.kakaobank.auth.request.MobileAuthForCustRequestDto;
import com.kakaobank.auth.request.MobileAuthRequestDto;
import com.kakaobank.auth.request.MobileValidForCustRequestDto;
import com.kakaobank.auth.request.MobileValidRequestDto;
import com.kakaobank.auth.request.PinAuthRequestDto;
import com.kakaobank.auth.response.E2eIdResponseDto;
import com.kakaobank.auth.response.MobileAuthResponseDto;
import com.kakaobank.auth.response.MobileValidResponseDto;
import com.kakaobank.auth.response.PinAuthResponseDto;

public class TestAuthService {

	private E2eAuthUtil e2eAuthUtil;
	private RestClient restClient;
	
	@Before
	public void setUp() throws Exception {
		this.restClient = new RestClient("10.13.16.71", 29201);
		this.e2eAuthUtil = new E2eAuthUtil();
		this.e2eAuthUtil.setRestClient(restClient);
	}
	
	@Test
	public void testMockCreation() throws Exception {
		assertNotNull(this.restClient);
		assertNotNull(this.e2eAuthUtil);
	}
	
	/**
	 * PIN 번호 인증 테스트
	 * @throws Exception
	 */
	@Test
	public void testCheckPinNumber() throws Exception {
		String userId = "1100000004";
		String tellerId = "751952";
		// 1. E2E 키 수신
		E2eIdRequestDto e2eIdRequestDto = new E2eIdRequestDto();
		e2eIdRequestDto.setUser_id(userId);
		e2eIdRequestDto.setTeller_id(tellerId);
		E2eIdResponseDto e2eIdResponseDto = this.e2eAuthUtil.getE2eId(e2eIdRequestDto);
		if(e2eIdResponseDto != null){
			// 2. PIN / 해제코드 번호 인증 수신
			PinAuthRequestDto requestDto = new PinAuthRequestDto();
			requestDto.setUser_id(userId);
			requestDto.setPinNum("123456798");
			
			PinAuthResponseDto actual = this.e2eAuthUtil.requestPinNumberAuthentication(e2eIdResponseDto, requestDto);
			if(actual != null){
				// 3. 응답결과 확인
				System.out.println(actual.toString());
				assertNotNull(actual.getCode());
				assertNotNull(actual.getErrCount());
				assertNotNull(actual.getMessage());
			} else {
				System.out.println("PIN 번호 인증 결과를 가져올 수 없습니다.");
				assertTrue(false);
			}
		} else {
			System.out.println("E2E ID를 가져올 수 없습니다.");
			assertTrue(false);
		}
	}
	
	/**
	 * 회원 휴대폰 번호 인증 테스트
	 * @throws Exception
	 */
//	@Test
	public void testCheckPhoneAuthForRegCust() throws Exception {
		String userId = "1100000004";
		String tellerId = "751952";
		String name = "홍길동";
		String venderCode = "01";
		String phoneNumber = "01012345678";
		String birthDay = "19821231";
		// 1. E2E 키 수신
		E2eIdRequestDto e2eIdRequestDto = new E2eIdRequestDto();
		e2eIdRequestDto.setUser_id(userId);
		e2eIdRequestDto.setTeller_id(tellerId);
		E2eIdResponseDto e2eIdResponseDto = this.e2eAuthUtil.getE2eId(e2eIdRequestDto);
		if(e2eIdResponseDto != null){
			// 2. 휴대폰 본인확인 여부 수신
			MobileAuthForCustRequestDto requestDto = new MobileAuthForCustRequestDto();
			requestDto.setUser_id(userId);
			requestDto.setName(name);
			requestDto.setVenderCode(venderCode);
			requestDto.setPhoneNumber(phoneNumber);
			requestDto.setBirthDay(birthDay);
			
			MobileAuthResponseDto actual = this.e2eAuthUtil.requestMobileAuthentication(e2eIdResponseDto, requestDto);
			if(actual != null){
				// 3. 응답결과 확인
				System.out.println(actual.toString());
				assertNotNull(actual.getCode());
				assertNotNull(actual.getErrCount());
				assertNotNull(actual.getMessage());
				assertNotNull(actual.getValidation_id());
			} else {
				System.out.println("PIN 번호 인증 결과를 가져올 수 없습니다.");
				assertTrue(false);
			}
		} else {
			System.out.println("E2E ID를 가져올 수 없습니다.");
			assertTrue(false);
		}
	}
	
	/**
	 * 회원 휴대폰 번호 검증 테스트
	 * @throws Exception
	 */
//	@Test
	public void testCheckPhoneValidForRegCust() throws Exception {
		String userId = "1100000004";
		String validationId = "123456789";
		String arthNo = "3456";
		// 1. 휴대폰 검증 수신
		MobileValidForCustRequestDto requestDto = new MobileValidForCustRequestDto();
		requestDto.setUser_id(userId);
		requestDto.setValidation_id(validationId);
		requestDto.setArth_no(arthNo);
		
		MobileValidResponseDto actual = this.e2eAuthUtil.requestMobileValidataion(requestDto);
		if(actual != null){
			// 2. 응답결과 반환
			System.out.println(actual.toString());
			assertNotNull(actual.getVender_code());
			assertNotNull(actual.getCode());
			assertNotNull(actual.getMessage());
			assertNotNull(actual.getPhone_number());
			assertNotNull(actual.getCiNo());
		} else {
			System.out.println("휴대폰번호 검증 결과를 가져올 수 없습니다.");
			assertTrue(false);
		}
	}
	
	/**
	 * 비회원 휴대폰 번호 인증 테스트
	 * @throws Exception
	 */
//	@Test
	public void testCheckPhoneAuthForNoRegCust() throws Exception {
		String tellerId = "751952";
		String custNm = "홍길동";
		String venderCode = "01";
		String phoneNumber = "01012345678";
		String birthDay = "19801231";
		
		E2eIdRequestDto e2eIdRequestDto = new E2eIdRequestDto();
		e2eIdRequestDto.setTeller_id(tellerId);
		E2eIdResponseDto e2eIdResponseDto = this.e2eAuthUtil.getE2eId(e2eIdRequestDto);
		if(e2eIdResponseDto != null){
			// 1. 휴대폰 본인확인 여부 수신
			MobileAuthRequestDto requestDto = new MobileAuthRequestDto();
			requestDto.setName(custNm);
			requestDto.setVenderCode(venderCode);
			requestDto.setPhoneNumber(phoneNumber);
			requestDto.setBirthDay(birthDay);
			
			MobileAuthResponseDto actual = this.e2eAuthUtil.requestMobileAuthentication(e2eIdResponseDto, requestDto);
			if(actual != null){
				// 2. 응답결과 반환
				System.out.println(actual.toString());
				assertNotNull(actual.getCode());
				assertNotNull(actual.getErrCount());
				assertNotNull(actual.getMessage());
				assertNotNull(actual.getValidation_id());
			} else {
				System.out.println("휴대폰번호 인증 결과를 가져올 수 없습니다. [비회원고객, E2E ID : " + e2eIdResponseDto.getE2e_id() +"]");
				assertTrue(false);
			}
		} else {
			System.out.println("E2E ID를 가져올 수 없습니다. [비회원고객]");
			assertTrue(false);
		}
	}
	
	/**
	 * 비회원 휴대폰 번호 검증 테스트
	 * @throws Exception
	 */
//	@Test
	public void testCheckPhoneValidForNoRegCust() throws Exception {
		String validationId = "123456789";
		String arthNo = "3456";
		// 1. 휴대폰 검증 수신
		MobileValidRequestDto requestDto = new MobileValidRequestDto();
		requestDto.setValidation_id(validationId);
		requestDto.setArth_no(arthNo);
		
		MobileValidResponseDto actual = this.e2eAuthUtil.requestMobileValidataion(requestDto);
		if(actual != null){
			// 2. 응답결과 반환
			System.out.println(actual.toString());
			assertNotNull(actual.getVender_code());
			assertNotNull(actual.getCode());
			assertNotNull(actual.getMessage());
			assertNotNull(actual.getPhone_number());
			assertNotNull(actual.getCiNo());
		} else {
			System.out.println("휴대폰번호 검증 결과를 가져올 수 없습니다.");
			assertTrue(false);
		}
	}
}
