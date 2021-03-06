package com.kakaobank.restclient.convert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kakaobank.restclient.request.RestRequest;

/**
 * URL String Message Converter
 * @author 박상준
 *
 */
public class UrlStringMessageConverter implements MessageConverter {
	private final String DEFAULT_ENCODING = "UTF-8";
	
	@Override
	public String messageConvert(RestRequest request){
		List<NameValuePair> paramList = this.convertParam(request);
		String message = URLEncodedUtils.format(paramList, this.DEFAULT_ENCODING);
		System.out.println("REQUEST PARAMETER : " + message);
		return message;
	}
	
	private List<NameValuePair> convertParam(RestRequest request){
		@SuppressWarnings("unchecked")
		Map<String, Object> paramMap = new ObjectMapper().convertValue(request, HashMap.class);
		List<NameValuePair> paramList = new ArrayList<>();
		for(String key : paramMap.keySet()){
			paramList.add(new BasicNameValuePair(key, String.valueOf(paramMap.get(key))));
		}
		return paramList;
	}
}
