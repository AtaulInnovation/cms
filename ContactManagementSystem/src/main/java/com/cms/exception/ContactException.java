package com.cms.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "cause", "stackTrace", "suppressed", "localizedMessage" })
public class ContactException extends AppException {

    private static final long serialVersionUID = 1L;

    public ContactException(String errorType, String errorCode, String message) {
        super(errorType, errorCode, message);
    }
}
