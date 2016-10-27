package com.kakaobank.restclient.request;

import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpGet;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Abstract Rest Request - GET 방식
 * @author 박상준
 *
 */
public abstract class RestGetRequest implements RestRequest {
	public HttpRequest getHttpUriRequest() throws JsonProcessingException {
		HttpGet get = new HttpGet(this.getRequestPath() + "?" + this.getRequestParameters());
		get.addHeader("Accept", "application/json");
		return get;
	}
}
