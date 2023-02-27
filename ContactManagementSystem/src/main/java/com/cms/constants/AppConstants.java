package com.cms.constants;

public interface AppConstants {

    interface StatusCodes {
        int SUCCESS = 1;
        int FAILURE = 0;
    }

    interface ErrorCodes {
        String INVALID_INPUT_ERROR_CODE = "101";
        String CONTACT_NOT_FOUND_ERROR_CODE = "102";
    }

    interface ErrorTypes {
        String INVALID_INPUT_ERROR = "Invalid Input";
        String CONTACT_NOT_FOUND_ERROR = "Contact";
    }

    interface ErrorMessages {
        String INVALID_NULL_ID = "Id can't be null";
        String CONTACT_NOT_FOUND = "Contact Not Found";
        String NO_ANY_CONTACT_FOUND = "No any contact found";
    }
}
