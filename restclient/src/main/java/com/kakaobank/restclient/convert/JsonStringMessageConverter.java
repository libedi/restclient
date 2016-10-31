package com.kakaobank.restclient.convert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kakaobank.restclient.request.RestRequest;

/**
 * Json String Message Converter
 * @author 박상준
 *
 */
public class JsonStringMessageConverter implements MessageConverter {
	@Override
	public String messageConvert(RestRequest request) throws JsonProcessingException {
		String message = new ObjectMapper().writeValueAsString(request);
		System.out.println("REQUEST PARAMETER : " + message);
		return message;
	}
}
