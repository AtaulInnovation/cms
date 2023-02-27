package com.cms.advice;

import com.cms.constants.AppConstants;
import com.cms.exception.ContactException;
import com.cms.response.BaseApiResponse;
import com.cms.response.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UniversalControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ContactException.class)
    public ResponseEntity<BaseApiResponse> contactException(ContactException contactException) {
        BaseApiResponse baseApiResponse = new BaseApiResponse();
        baseApiResponse.setResponseStatus(new ResponseStatus(AppConstants.StatusCodes.FAILURE));
        baseApiResponse.setResponseData(contactException);
        return new ResponseEntity<>(baseApiResponse, HttpStatus.OK);
    }
}
