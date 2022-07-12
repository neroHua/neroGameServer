package com.nero.hua.exception;

public class BusinessException extends RuntimeException {

    private String code;

    public BusinessException(String message, String code) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, String code, Throwable cause) {
        super(message, cause);
    }

    public String getCode() {
        return code;
    }
}
