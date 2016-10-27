package com.kakaobank.restclient;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.kakaobank.restclient.request.RestRequest;
import com.kakaobank.restclient.response.RestResponse;

/**
 * Rest API Client
 * @author 박상준
 *
 */
public class RestClient {
	private String hostname;
	private int port;
	private boolean useHttps;
	
	public RestClient(String hostname) {
		this.hostname = hostname;
	}
	public RestClient(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
	}
	public RestClient(String hostname, int port, boolean useHttps) {
		this.hostname = hostname;
		this.port = port;
		this.useHttps = useHttps;
	}
	/**
	 * Rest API 요청
	 * @param restRequest
	 * @param t
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public <T> RestResponse<T> exchange(RestRequest restRequest, Class<T> t) throws ClientProtocolException, IOException{
		if(restRequest == null){
			throw new IllegalStateException("Request should not be a null.");
		}
		HttpHost host = new HttpHost(this.hostname, this.port, this.useHttps ? "https" : "http");
		HttpRequest request = restRequest.getHttpUriRequest();
		HttpClient client = new DefaultHttpClient();
		return new RestResponse<T>(client.execute(host, request), t);
	}
}
