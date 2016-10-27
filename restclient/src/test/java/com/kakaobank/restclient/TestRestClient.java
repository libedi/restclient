package com.kakaobank.restclient;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.kakaobank.restclient.dto.TestRequestDto;
import com.kakaobank.restclient.dto.TestResponseDto;
import com.kakaobank.restclient.response.RestResponse;

public class TestRestClient {

	private RestClient client;
	
	@Before
	public void setUp() throws Exception{
		client = new RestClient("10.13.16.71", 8080);
	}
	
	@Test
	public void testMockCreation() throws Exception{
		assertNotNull(client);
	}
	
	@Test
	public void testCallRestApi() throws Exception{
		TestRequestDto dto = new TestRequestDto();
		dto.setUserID("123456789");
		dto.setE2eID("987654321");
		dto.setValue("ABCDEFR");
		RestResponse<TestResponseDto> res = client.exchange(dto, TestResponseDto.class);
		assertNotNull(res);
		if(res.getContent() instanceof TestResponseDto){
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
	
}
