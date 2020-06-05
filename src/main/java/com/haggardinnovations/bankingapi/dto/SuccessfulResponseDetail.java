package com.haggardinnovations.bankingapi.dto;
import org.springframework.http.HttpStatus;

public class SuccessfulResponseDetail {
    private Integer code;
    private String message;
    private Object data;

    public SuccessfulResponseDetail() {}

    public SuccessfulResponseDetail(HttpStatus status, Object data){
        this.code = status.value();
        this.data = data;

    }

    public SuccessfulResponseDetail(HttpStatus status, String message) {
        this.code = status.value();
        this.message = message;

    }

    public SuccessfulResponseDetail(HttpStatus httpStatus, String message, Object data) {
        this.code = httpStatus.value();
        this.message = message;
        this.data = data;

    }


    public Integer getCode() {
        return code;

    }

    public void setCode(Integer code) {
        this.code = code;

    }


    public Object getData() {
        return data;

    }

    public void setData(Object data) {
        this.data = data;

    }

    public String getMessage() {
        return message;

    }


    public void setMessage(String message) {
        this.message = message;

    }

    @Override
    public String toString() {
        return "SuccessfulResponseDetails{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';

    }

}