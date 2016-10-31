package com.kakaobank.restclient;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.kakaobank.auth.request.E2eIdRequestDto;
import com.kakaobank.auth.response.E2eIdResponseDto;
import com.kakaobank.restclient.response.RestResponse;
import com.kakaobank.stamp.e2e.E2eEncryptor;

public class TestAuthKeyRequest {
	private RestClient client;
	
	@Before
	public void setUp() throws Exception {
		client = new RestClient("10.13.16.71", 8080);
	}
	
	@Test
	public void testMockCreation() throws Exception {
		assertNotNull(client);
	}
	
	@Test
	public void testE2dIdRequest() throws Exception {
		E2eEncryptor e2e = new E2eEncryptor();
		String publicKey = e2e.getCsPublicKey();
		
		E2eIdRequestDto e2eIdRequestDto = new E2eIdRequestDto();
		e2eIdRequestDto.setPublicKey(publicKey);
		e2eIdRequestDto.setUserID("10000000030");
		
		RestResponse<E2eIdResponseDto> res = client.exchange(e2eIdRequestDto, E2eIdResponseDto.class);
		if(res.has200StatusCode()){
			if(res.getContent() instanceof E2eIdResponseDto){
				assertTrue(true);
			}
			E2eIdResponseDto result = res.getContent();
			assertNotNull(result.getE2eId());
			assertNotNull(result.getPublic_key());
			
			System.out.println(result.getE2eId());
			System.out.println(result.getPublic_key());
		}
		
	}
}
