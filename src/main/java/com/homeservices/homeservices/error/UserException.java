package com.homeservices.homeservices.error;

import java.util.concurrent.ExecutorCompletionService;

/**
 * Created by nemanja on 9/30/2017.
 */
public class UserException extends Exception{

    private ErrorCode errorCode;
    private String errorMessage;

    public UserException(ErrorCode errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
