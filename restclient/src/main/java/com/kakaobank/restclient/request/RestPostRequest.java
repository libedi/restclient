package com.kakaobank.restclient.request;

import java.io.UnsupportedEncodingException;

import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.kakaobank.restclient.convert.MessageConverter;

/**
 * Abstract Rest Request - POST 방식
 * @author 박상준
 *
 */
public abstract class RestPostRequest implements RestRequest {
	@JsonIgnore
	protected MessageConverter messageConverter;
	
	@Override
	public HttpRequest getHttpRequest() throws UnsupportedEncodingException, JsonProcessingException {
		HttpPost post = new HttpPost(this.getRequestPath());
		post.addHeader("Accept", "application/json");
		post.addHeader("Content-Type", "application/json;charset=UTF-8");
		StringEntity stringEntity = new StringEntity(this.getRequestParameters(), "UTF-8");
		post.setEntity(stringEntity);
		return post;
	}
	
	@Override
	public String getRequestParameters() throws JsonProcessingException {
		return this.messageConverter.messageConvert(this);
	}
}
