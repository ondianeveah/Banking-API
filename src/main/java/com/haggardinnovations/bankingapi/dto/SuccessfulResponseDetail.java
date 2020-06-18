package com.haggardinnovations.bankingapi.dto;
import org.springframework.http.HttpStatus;

public class SuccessfulResponseDetail {
    private int code;
    private String message;
    private Object data;

    public SuccessfulResponseDetail() {}

    public SuccessfulResponseDetail(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public SuccessfulResponseDetail(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}