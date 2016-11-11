package com.kakaobank.restclient.request;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
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
	
	@JsonIgnore
	protected Map<String, String> headerMap;
	
	@Override
	public HttpRequest getHttpRequest() throws JsonProcessingException {
		HttpGet get = new HttpGet(this.getRequestPath() + "?" + this.getRequestParameters());
		get.addHeader(HttpHeaders.ACCEPT, "application/json");
		this.setCustomHeaders(get);
		this.printHeaders(get);
		return get;
	}
	
	@Override
	public String getRequestParameters() throws JsonProcessingException {
		return this.messageConverter.messageConvert(this);
	}
	
	private void setCustomHeaders(HttpRequest httpRequest){
		if(this.headerMap != null){
			Iterator<Entry<String, String>> entrySet = this.headerMap.entrySet().iterator();
			while(entrySet.hasNext()){
				Entry<String, String> entry = entrySet.next();
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
}
