package com.kakaobank.restclient.exception;

/**
 * Rest Client Exception
 * @author 박상준
 *
 */
public class RequestException extends Exception {

	private static final long serialVersionUID = -6886011691765728086L;

	public RequestException() {
		super();
	}

	public RequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public RequestException(String message) {
		super(message);
	}

	public RequestException(Throwable cause) {
		super(cause);
	}

	
}
