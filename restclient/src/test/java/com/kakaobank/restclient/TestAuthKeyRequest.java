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
		client = new RestClient("10.13.16.71", 29201);
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
		e2eIdRequestDto.setTellerId("10000000030");
		
		RestResponse<E2eIdResponseDto> res = client.exchange(e2eIdRequestDto, E2eIdResponseDto.class);
		System.out.println("STATUS CODE : " + res.getStatusCode());
		
		if(res != null){
			if(res.has200StatusCode() && res.getContent() instanceof E2eIdResponseDto){
				E2eIdResponseDto result = res.getContent();
				assertNotNull(result.getE2eId());
				assertNotNull(result.getServerPublicKey());
				
				System.out.println(result.getE2eId());
				System.out.println(result.getServerPublicKey());
				assertTrue(true);
			} else {
				System.out.println("" + res.getResponse().getStatusLine().getReasonPhrase());
				assertTrue(false);
			}
		}
	}
}
