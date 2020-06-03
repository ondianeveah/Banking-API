package com.haggardinnovations.bankingapi.handler;

import com.haggardinnovations.bankingapi.dto.ErrorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static org.aspectj.bridge.Version.getTime;

//@ControllerAdvice
public class CustomerExceptionHandler {
//
//    @Autowired
//    private MessageSource messages;
//
//    @ExceptionHandler(ResourceNotFound.class)
//    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFound rnf, HttpServletRequest request) {
//
//        ErrorDetail errorDetail = new ErrorDetail();
//        errorDetail.setTimeStamp(new Date()getTime());
//        errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
//        errorDetail.setTitle("Resource not found");
//        errorDetail.setDetail(rnf.getMessage());
//        errorDetail.setDeveloperMessage(rnf.getClass().getName());
//
//        return new ResponseEntity<>(errorDetail, null, HttpStatus.NOT_FOUND);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exc, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        ErrorDetail errorDetail = new ErrorDetail();
//        errorDetail
//    }
//
//}
