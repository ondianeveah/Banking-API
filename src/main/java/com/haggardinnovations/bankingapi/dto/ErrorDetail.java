package com.haggardinnovations.bankingapi.dto;

public class ErrorDetail {
    private int code;
    private String message;

    public ErrorDetail(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorDetail(){

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorDetail{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
