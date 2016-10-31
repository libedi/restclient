package com.kakaobank.restclient.response;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Rest Response Class
 * @author 박상준
 *
 * @param <T>
 */
public class RestResponse<T> {
	private final String DEFAULT_ENCODING = "UTF-8";
	private final String EMPTY_JSON_STRING = "{}";
	
	private HttpResponse response;
	private T content;
	
	public RestResponse(HttpResponse response, Class<T> clazz) throws ParseException, IOException {
		this.response = response;
		HttpEntity entity = response.getEntity();
		String result = (entity == null) ? this.EMPTY_JSON_STRING : EntityUtils.toString(entity, this.DEFAULT_ENCODING);
		this.content = new ObjectMapper().readValue(result, clazz);
		this.printResponseInfo();
	}

	public T getContent(){
		return this.content;
	}

	public HttpResponse getResponse() {
		return response;
	}
	
	public int getStatusCode(){
		return this.response.getStatusLine().getStatusCode();
	}
	
	public boolean has1xxStatusCode() {
		return this.getFirstDigitOfStatusCode() == 1;
	}

	public boolean has2xxStatusCode() {
		return this.getFirstDigitOfStatusCode() == 2;
	}

	public boolean has3xxStatusCode() {
		return this.getFirstDigitOfStatusCode() == 3;
	}

	public boolean has4xxStatusCode() {
		return this.getFirstDigitOfStatusCode() == 4;
	}

	public boolean has5xxStatusCode() {
		return this.getFirstDigitOfStatusCode() == 5;
	}

	public boolean has200StatusCode() {
		return this.isStatusCode(HttpStatus.SC_OK);
	}

	public boolean has201StatusCode() {
		return this.isStatusCode(HttpStatus.SC_CREATED);
	}

	private boolean isStatusCode(int expectedStatusCode) {
		return this.getStatusCode() == expectedStatusCode;
	}
	
	private int getFirstDigitOfStatusCode() {
		return this.getStatusCode() / 100;
	}
	
	private void printResponseInfo(){
		HttpEntity entity = this.response.getEntity();
		StringBuilder sb = new StringBuilder();
		sb.append("----------------------------------------\n");
		sb.append(this.response.getStatusLine()).append("\n");
		Header[] headers = this.response.getAllHeaders();
		for (int i=0; i<headers.length; ++i) {
			sb.append(headers[i]).append("\n");
		}
		sb.append("----------------------------------------\n");
		if (entity != null) {
			try {
				sb.append(new ObjectMapper().writeValueAsString(this.getContent())).append("\n");
			} catch (IOException e) {
				sb.append("Cannot convert entity to String\n");
			}
		} else {
			sb.append("No entity.\n");
		}
		System.out.println(sb.toString());
	}
}
