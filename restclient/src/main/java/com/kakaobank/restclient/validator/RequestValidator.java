package com.kakaobank.restclient.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.kakaobank.restclient.exception.RequestException;
import com.kakaobank.restclient.request.RestRequest;

/**
 * Rest Request Validator
 * @author 박상준
 *
 */
public class RequestValidator {
	public static void validate(RestRequest restRequest) throws RequestException{
		if(restRequest == null){
			throw new RequestException("Invalid Request Object : null");
		}
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<RestRequest>> constraintViolations = validator.validate(restRequest);
		if(constraintViolations.size() > 0){
			for(ConstraintViolation<RestRequest> cv : constraintViolations){
				System.out.println("MODEL: " + cv.getLeafBean().getClass().getSimpleName() + ", FIELD: " + cv.getPropertyPath() + ", MESSAGE: " + cv.getMessage());
			}
			throw new RequestException("Invalid Request parameter.");
		}
	}
}
