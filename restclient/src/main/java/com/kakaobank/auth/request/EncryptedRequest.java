package com.kakaobank.auth.request;

import org.hibernate.validator.constraints.NotEmpty;

import com.kakaobank.restclient.request.RestPostRequest;

/**
 * 데이터 암호화 abstract class
 * @author 박상준
 *
 */
public abstract class EncryptedRequest extends RestPostRequest{
	@NotEmpty
	protected String e2e_id;		// E2E ID

	public String getE2e_id() {
		return e2e_id;
	}

	public void setE2e_id(String e2e_id) {
		this.e2e_id = e2e_id;
	}

}
