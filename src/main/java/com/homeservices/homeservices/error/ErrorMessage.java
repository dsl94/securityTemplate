package com.homeservices.homeservices.error;

/**
 * Created by nemanja on 9/30/2017.
 */
public class ErrorMessage {

    private ErrorCode errorCode;
    private String message;

    public ErrorMessage(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
