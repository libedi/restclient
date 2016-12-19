package com.kakaobank.restclient.convert;

/**
 * MessageConverter Factory Class
 * @author 박상준
 *
 */
public class MessageConverterFactory {
	
	/**
	 * MessageConverter 생성
	 * @param messageType
	 * @return MessageConverter
	 */
	public static MessageConverter createMessageConverter(MessageType messageType){
		switch(messageType){
		case JSON:
			return new JsonStringMessageConverter();
		case URL:
			return new UrlStringMessageConverter();
		default:
			throw new IllegalArgumentException("Invalid MessageType argument");
		}
	}
}
