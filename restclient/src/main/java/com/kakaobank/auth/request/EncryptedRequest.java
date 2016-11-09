package com.kakaobank.auth.request;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kakaobank.restclient.request.RestPostRequest;

/**
 * 데이터 암호화 abstract class
 * @author 박상준
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public abstract class EncryptedRequest extends RestPostRequest{
	@NotEmpty
	protected String e2eId;		// E2E ID
	@NotEmpty
	protected String guid;		// GUID

	public String getE2eId() {
		return e2eId;
	}

	public void setE2eId(String e2eId) {
		this.e2eId = e2eId;
	}
	
	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}
	
	protected String makeGuid(){
		return new StringBuilder()
				.append("037CCSTMA039D")
				.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()))
				.append(String.format("%06d", (int) (Math.random() * 1000000)))
				.append("001")
				.toString();
	}

}
