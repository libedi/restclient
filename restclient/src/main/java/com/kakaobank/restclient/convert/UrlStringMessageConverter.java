package com.kakaobank.restclient.convert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
public class UrlStringMessageConverter {
	private static final Log logger = LogFactory.getLog(UrlStringMessageConverter.class);
	private final String DEFAULT_ENCODING = "UTF-8";
	
	@SuppressWarnings("unchecked")
	public String messageConvert(RestRequest request){
		ObjectMapper mapper  = new ObjectMapper();
		Map<String, Object> paramMap = mapper.convertValue(request, Map.class);
		List<NameValuePair> paramList = this.convertParam(paramMap);
		String message = URLEncodedUtils.format(paramList, this.DEFAULT_ENCODING);
//		if(logger.isDebugEnabled()){
//			logger.debug("PARAM : " + message);
//		}
		System.out.println("PARAM : " + message);
		return message;
	}
	
	private List<NameValuePair> convertParam(Map<String, Object> paramMap){
		List<NameValuePair> paramList = new ArrayList<>();
		Iterator<String> keys = paramMap.keySet().iterator();
		String key = null;
		while(keys.hasNext()){
			key = keys.next();
			paramList.add(new BasicNameValuePair(key, (String) paramMap.get(key)));
		}
		return paramList;
	}
}
