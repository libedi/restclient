package com.kakaobank.auth.request;

import com.kakaobank.restclient.request.RestPostRequest;

/**
 * 데이터 암호화 abstract class
 * @author 박상준
 *
 */
public abstract class EncryptedRequest extends RestPostRequest{
	protected String e2eID;		// E2E ID

	public String getE2eID() {
		return e2eID;
	}

	public void setE2eID(String e2eID) {
		this.e2eID = e2eID;
	}

}
