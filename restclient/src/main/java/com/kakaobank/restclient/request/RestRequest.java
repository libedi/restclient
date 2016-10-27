package com.kakaobank.restclient.request;

import java.io.UnsupportedEncodingException;

import org.apache.http.HttpRequest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface RestRequest {
	@JsonIgnore
	HttpRequest getHttpUriRequest() throws UnsupportedEncodingException, JsonProcessingException;
	
	@JsonIgnore
	String getRequestPath();
	
	@JsonIgnore
	String getRequestParameters() throws JsonProcessingException;
}
