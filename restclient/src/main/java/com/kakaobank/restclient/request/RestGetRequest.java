package com.kakaobank.restclient.request;

import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpGet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.kakaobank.restclient.convert.MessageConverter;

/**
 * Abstract Rest Request - GET 방식
 * @author 박상준
 *
 */
public abstract class RestGetRequest implements RestRequest {
	@JsonIgnore
	protected MessageConverter messageConverter;
	
	@Override
	public HttpRequest getHttpRequest() throws JsonProcessingException {
		HttpGet get = new HttpGet(this.getRequestPath() + "?" + this.getRequestParameters());
		get.addHeader("Accept", "application/json");
		return get;
	}
	
	@Override
	public String getRequestParameters() throws JsonProcessingException {
		return this.messageConverter.messageConvert(this);
	}
}
