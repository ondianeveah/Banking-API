package com.haggardinnovations.bankingapi.dto;

public class ErrorDetail {
    private Long code;
    private String message;

    public ErrorDetail(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorDetail(){

    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
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
