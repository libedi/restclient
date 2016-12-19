package com.kakaobank.restclient.request;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
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
	
	@JsonIgnore
	protected Map<String, String> headerMap;
	
	public Map<String, String> getHeaderMap() {
		return headerMap;
	}
	
	@Override
	public HttpRequest getHttpRequest() throws UnsupportedEncodingException, JsonProcessingException {
		HttpPost post = new HttpPost(this.getRequestPath());
		post.addHeader(HttpHeaders.ACCEPT, "application/json");
		post.addHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8");
		this.setCustomHeaders(post);
		this.printHeaders(post);
		StringEntity stringEntity = new StringEntity(this.getRequestParameters(), "UTF-8");
		post.setEntity(stringEntity);
		return post;
	}
	
	@Override
	public String getRequestParameters() throws JsonProcessingException {
		this.setMessageConverter();
		return this.messageConverter.messageConvert(this);
	}
	
	private void setCustomHeaders(HttpRequest httpRequest){
		if(this.headerMap != null){
			for(Entry<String, String> entry : this.headerMap.entrySet()){
				httpRequest.addHeader(entry.getKey(), entry.getValue());
			}
		}
	}
	
	private void printHeaders(HttpRequest httpRequest){
		StringBuilder sb = new StringBuilder();
		for(Header header : httpRequest.getAllHeaders()){
			System.out.println(sb.append("REQUEST HEADER : ").append(header).toString());
			sb.setLength(0);
		}
	}
	
	protected abstract void setMessageConverter();
}
