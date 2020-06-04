package com.haggardinnovations.bankingapi.handler;

import com.haggardinnovations.bankingapi.dto.ErrorDetail;
import com.haggardinnovations.bankingapi.exceptions.ResourceNotFoundException;
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
import static org.springframework.http.ResponseEntity.notFound;

@ControllerAdvice
public class CustomerExceptionHandler {

    @Autowired
    private MessageSource messages;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException rnf) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;

//    ResourceNotFoundException resourceNotFoundException = new ResourceNotFoundException(
//        rnf.getMessage(),
//        notFound,
//        rnf;
//        );

         ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
        errorDetail.setMessage("Error fetching customer accounts");
        errorDetail.setCode(400L);



        return new ResponseEntity<>(errorDetail, notFound);
    }


}
