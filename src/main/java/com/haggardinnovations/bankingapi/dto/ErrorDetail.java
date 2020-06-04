package com.haggardinnovations.bankingapi.dto;

public class ErrorDetail {
    private Long code;
    private String message;
    private int status;

    public ErrorDetail(Long code, String message) {
        this.code = code;
        this.message = message;

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
                ", status=" + status +
                '}';
    }
}
