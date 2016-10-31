package com.kakaobank.restclient.convert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kakaobank.restclient.request.RestRequest;

/**
 * Message Converter Interface
 * @author 박상준
 *
 */
public interface MessageConverter {
	String messageConvert(RestRequest restGetRequest) throws JsonProcessingException;
}
