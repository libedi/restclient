package com.kakaobank.restclient.convert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kakaobank.restclient.request.RestRequest;

/**
 * Json String Message Converter
 * @author 박상준
 *
 */
public class JsonStringMessageConverter {
	private static final Log logger = LogFactory.getLog(JsonStringMessageConverter.class);
	
	public String messageConvert(RestRequest request) throws JsonProcessingException {
		String message = new ObjectMapper().writeValueAsString(request);
//		if(logger.isDebugEnabled()){
//			logger.debug("PARAM : " + message);
//		}
		System.out.println("PARAM : " + message);
		return message;
	}
}
