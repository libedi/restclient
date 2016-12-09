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
import com.kakaobank.auth.request.OtpUnlockAuthRequestDto;
import com.kakaobank.auth.request.PinAuthRequestDto;
import com.kakaobank.auth.request.UnlockFirstRegRequestDto;
import com.kakaobank.auth.request.UnlockSecondRegRequestDto;
import com.kakaobank.auth.request.UserAuthStatusRequestDto;
import com.kakaobank.auth.response.E2eIdResponseDto;
import com.kakaobank.auth.response.MobileAuthResponseDto;
import com.kakaobank.auth.response.MobileValidResponseDto;
import com.kakaobank.auth.response.PinAuthResponseDto;
import com.kakaobank.auth.response.UnlockCodeResponseDto;
import com.kakaobank.auth.response.UserAuthStatusResponseDto;

public class TestAuthService {

	private E2eAuthUtil e2eAuthUtil;
	private RestClient restClient;
	
	@Before
	public void setUp() throws Exception {
		this.restClient = new RestClient("10.13.12.26", 29201);
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
//	@Test
	public void testCheckPinNumber() throws Exception {
		String userId = "test_user";
		String tellerId = "751952";
		String pinNumber = "123456";
		String cstNo = "11000000045";
		// 1. E2E 키 수신
		E2eIdRequestDto e2eIdRequestDto = new E2eIdRequestDto();
		e2eIdRequestDto.setUserId(userId);
		e2eIdRequestDto.setTellerId(tellerId);
		E2eIdResponseDto e2eIdResponseDto = this.e2eAuthUtil.getE2eId(e2eIdRequestDto);
		if(e2eIdResponseDto != null){
			// 2. PIN / 해제코드 번호 인증 수신
			PinAuthRequestDto requestDto = new PinAuthRequestDto();
			requestDto.setUserId(userId);
			requestDto.setTellerId(tellerId);
			requestDto.setPinNum(pinNumber);
			requestDto.setCstNo(cstNo);
			
			PinAuthResponseDto actual = this.e2eAuthUtil.requestPinNumberAuthentication(e2eIdResponseDto, requestDto);
			if(actual != null){
				// 3. 응답결과 확인
				System.out.println(actual.toString());
				assertNotNull(actual.getCode());
				assertNotNull(actual.getFailCount());
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
		String cstNo = "11000000045";
		String tellerId = "751952";
		String name = "박상준";
		String vendorCode = "01";
		String phoneNumber = "01090718222";
		String birthdayAndGender = "8302071";
		// 1. E2E 키 수신
		E2eIdRequestDto e2eIdRequestDto = new E2eIdRequestDto();
		e2eIdRequestDto.setUserId(userId);
		e2eIdRequestDto.setTellerId(tellerId);
		E2eIdResponseDto e2eIdResponseDto = this.e2eAuthUtil.getE2eId(e2eIdRequestDto);
		if(e2eIdResponseDto != null){
			// 2. 휴대폰 본인확인 여부 수신
			MobileAuthForCustRequestDto requestDto = new MobileAuthForCustRequestDto();
			requestDto.setUserId(userId);
			requestDto.setName(name);
			requestDto.setVendorCode(vendorCode);
			requestDto.setPhoneNumber(phoneNumber);
			requestDto.setBirthdayAndGender(birthdayAndGender);
			requestDto.setCstNo(cstNo);
			
			MobileAuthResponseDto actual = this.e2eAuthUtil.requestMobileAuthentication(e2eIdResponseDto, requestDto);
			if(actual != null){
				// 3. 응답결과 확인
				System.out.println(actual.toString());
				assertNotNull(actual.getCode());
				assertNotNull(actual.getFailCount());
				assertNotNull(actual.getMessage());
				assertNotNull(actual.getValidationId());
			} else {
				System.out.println("휴대폰번호 인증 결과를 가져올 수 없습니다. [회원고객, E2E ID : " + e2eIdResponseDto.getE2eId() +"]");
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
	@Test
	public void testCheckPhoneValidForRegCust() throws Exception {
		String userId = "1100000004";
		String cstNo = "11000000045";
		String tellerId = "751952";
		String validationId = "1344950577443898400";
		String authNo = "706096";
		String ci = "";
		// 1. E2E 키 수신
		E2eIdRequestDto e2eIdRequestDto = new E2eIdRequestDto();
		e2eIdRequestDto.setUserId(userId);
		e2eIdRequestDto.setTellerId(tellerId);
		E2eIdResponseDto e2eIdResponseDto = this.e2eAuthUtil.getE2eId(e2eIdRequestDto);
		if(e2eIdResponseDto != null){
			// 2. 휴대폰 검증 수신
			MobileValidForCustRequestDto requestDto = new MobileValidForCustRequestDto();
			requestDto.setUserId(userId);
			requestDto.setValidationId(validationId);
			requestDto.setAuthNo(authNo);
			requestDto.setCstNo(cstNo);
			requestDto.setCi(ci);
			
			MobileValidResponseDto actual = this.e2eAuthUtil.requestMobileValidataion(e2eIdResponseDto, requestDto);
			if(actual != null){
				// 3. 응답결과 반환
				System.out.println(actual.toString());
				assertNotNull(actual.getVendorCode());
				assertNotNull(actual.getCode());
				assertNotNull(actual.getMessage());
				assertNotNull(actual.getPhoneNumber());
				assertNotNull(actual.getCi());
				assertNotNull(actual.getName());
				assertNotNull(actual.getBirthdayAndGender());
				assertTrue(actual.getIsEqualsCiNo());
			} else {
				System.out.println("휴대폰번호 검증 결과를 가져올 수 없습니다.");
				assertTrue(false);
			}
		} else {
			System.out.println("E2E ID를 가져올 수 없습니다.");
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
		String custNm = "박상준";
		String vendorCode = "01";
		String phoneNumber = "01090718222";
		String birthdayAndGender = "8302071";
		
		E2eIdRequestDto e2eIdRequestDto = new E2eIdRequestDto();
		e2eIdRequestDto.setTellerId(tellerId);
		E2eIdResponseDto e2eIdResponseDto = this.e2eAuthUtil.getE2eId(e2eIdRequestDto);
		if(e2eIdResponseDto != null){
			// 1. 휴대폰 본인확인 여부 수신
			MobileAuthRequestDto requestDto = new MobileAuthRequestDto();
			requestDto.setName(custNm);
			requestDto.setVendorCode(vendorCode);
			requestDto.setPhoneNumber(phoneNumber);
			requestDto.setBirthdayAndGender(birthdayAndGender);
			
			MobileAuthResponseDto actual = this.e2eAuthUtil.requestMobileAuthentication(e2eIdResponseDto, requestDto);
			if(actual != null){
				// 2. 응답결과 반환
				System.out.println(actual.toString());
				assertNotNull(actual.getCode());
				assertNotNull(actual.getFailCount());
				assertNotNull(actual.getMessage());
				assertNotNull(actual.getValidationId());
			} else {
				System.out.println("휴대폰번호 인증 결과를 가져올 수 없습니다. [비회원고객, E2E ID : " + e2eIdResponseDto.getE2eId() +"]");
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
		String tellerId = "751952";
		String validationId = "1336804448080494657";
		String authNo = "894429";
		// 1. E2E 키 수신
		E2eIdRequestDto e2eIdRequestDto = new E2eIdRequestDto();
		e2eIdRequestDto.setTellerId(tellerId);
		E2eIdResponseDto e2eIdResponseDto = this.e2eAuthUtil.getE2eId(e2eIdRequestDto);
		if(e2eIdResponseDto != null){
			// 2. 휴대폰 검증 수신
			MobileValidRequestDto requestDto = new MobileValidRequestDto();
			requestDto.setValidationId(validationId);
			requestDto.setAuthNo(authNo);
			
			MobileValidResponseDto actual = this.e2eAuthUtil.requestMobileValidataion(e2eIdResponseDto, requestDto);
			if(actual != null){
				// 3. 응답결과 반환
				System.out.println(actual.toString());
				assertNotNull(actual.getVendorCode());
				assertNotNull(actual.getCode());
				assertNotNull(actual.getMessage());
				assertNotNull(actual.getPhoneNumber());
				assertNotNull(actual.getCi());
				assertNotNull(actual.getName());
				assertNotNull(actual.getBirthdayAndGender());
			} else {
				System.out.println("휴대폰번호 검증 결과를 가져올 수 없습니다.");
				assertTrue(false);
			}
		} else {
			System.out.println("E2E ID를 가져올 수 없습니다. [비회원고객]");
			assertTrue(false);
		}
	}
	
	/**
	 * 해제코드 1차등록 테스트
	 * @throws Exception
	 */
//	@Test
	public void testRegUnlockCodeFirst() throws Exception {
		String userId = "test_user";
		String cstNo = "11000000045";
		String tellerId = "751952";
		String unlockCode = "123456";
		// 1. E2E 키 수신
		E2eIdRequestDto e2eIdRequestDto = new E2eIdRequestDto();
		e2eIdRequestDto.setUserId(userId);
		e2eIdRequestDto.setTellerId(tellerId);
		E2eIdResponseDto e2eIdResponseDto = this.e2eAuthUtil.getE2eId(e2eIdRequestDto);
		if(e2eIdResponseDto != null){
			// 2. 해제코드 등록
			UnlockFirstRegRequestDto requestDto = new UnlockFirstRegRequestDto();
			requestDto.setUserId(userId);
			requestDto.setValue(unlockCode);
			requestDto.setCstNo(cstNo);
			
			UnlockCodeResponseDto actual = this.e2eAuthUtil.requestUnlockCodeFirstRegistration(e2eIdResponseDto, requestDto);
			if(actual != null){
				// 3. 응답결과 반환
				System.out.println(actual.toString());
				assertNotNull(actual.getCode());
				assertNotNull(actual.getMessage());
			} else {
				System.out.println("휴대폰번호 검증 결과를 가져올 수 없습니다.");
				assertTrue(false);
			}
		} else {
			System.out.println("E2E ID를 가져올 수 없습니다. [비회원고객]");
			assertTrue(false);
		}
	}
	
	/**
	 * 해제코드 2차등록 테스트
	 * @throws Exception
	 */
//	@Test
	public void testRegUnlockCodeSecond() throws Exception {
		String userId = "1100000004";
		String cstNo = "11000000045";
		String tellerId = "751952";
		String unlockCode = "123456";
		// 1. E2E 키 수신
		E2eIdRequestDto e2eIdRequestDto = new E2eIdRequestDto();
		e2eIdRequestDto.setUserId(userId);
		e2eIdRequestDto.setTellerId(tellerId);
		E2eIdResponseDto e2eIdResponseDto = this.e2eAuthUtil.getE2eId(e2eIdRequestDto);
		if(e2eIdResponseDto != null){
			UnlockSecondRegRequestDto requestDto = new UnlockSecondRegRequestDto();
			requestDto.setUserId(userId);
			requestDto.setUnlockCode(unlockCode);
			requestDto.setCstNo(cstNo);
			
			UnlockCodeResponseDto actual = this.e2eAuthUtil.requestUnlockCodeSecondRegistration(e2eIdResponseDto, requestDto);
			if(actual != null){
				// 3. 응답결과 반환
				System.out.println(actual.toString());
				assertNotNull(actual.getCode());
				assertNotNull(actual.getMessage());
			} else {
				System.out.println("휴대폰번호 검증 결과를 가져올 수 없습니다.");
				assertTrue(false);
			}
		} else {
			System.out.println("E2E ID를 가져올 수 없습니다. [비회원고객]");
			assertTrue(false);
		}
	}
	
	/**
	 * 해제코드 인증 테스트
	 * @throws Exception
	 */
//	@Test
	public void testUnlockAuthentication() throws Exception {
		String userId = "1100000004";
		String cstNo = "11000000045";
		String tellerId = "751952";
		String unlockCode = "123456";
		// 1. E2E 키 수신
		E2eIdRequestDto e2eIdRequestDto = new E2eIdRequestDto();
		e2eIdRequestDto.setUserId(userId);
		e2eIdRequestDto.setTellerId(tellerId);
		E2eIdResponseDto e2eIdResponseDto = this.e2eAuthUtil.getE2eId(e2eIdRequestDto);
		if(e2eIdResponseDto != null){
			OtpUnlockAuthRequestDto requestDto = new OtpUnlockAuthRequestDto();
			requestDto.setUserId(userId);
			requestDto.setOtpUnlockCode(unlockCode);
			requestDto.setCstNo(cstNo);
			
			UnlockCodeResponseDto actual = this.e2eAuthUtil.requestOtpUnlockCodeAuthentication(e2eIdResponseDto, requestDto);
			if(actual != null){
				// 3. 응답결과 반환
				System.out.println(actual.toString());
				assertNotNull(actual.getCode());
				assertNotNull(actual.getMessage());
			} else {
				System.out.println("해제코드 인증 결과를 가져올 수 없습니다.");
				assertTrue(false);
			}
		} else {
			System.out.println("E2E ID를 가져올 수 없습니다.");
			assertTrue(false);
		}
	}
	
	/**
	 * 사용자 인증 수단 조회 테스트
	 * @throws Exception
	 */
//	@Test
	public void testUserAuthentication() throws Exception {
		String userId = "test_user";
		UserAuthStatusRequestDto requestDto = new UserAuthStatusRequestDto();
		requestDto.setUserId(userId);
		
		UserAuthStatusResponseDto actual = this.e2eAuthUtil.requestUserAuthenticationStatus(requestDto);
		if(actual != null){
			// 3. 응답결과 반환
			System.out.println(actual.toString());
			assertNotNull(actual.getCode());
			assertNotNull(actual.getMessage());
		} else {
			System.out.println("사용자 인증 수단 조회 결과를 가져올 수 없습니다.");
			assertTrue(false);
		}
	}
}
