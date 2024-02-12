package com.myblog11.myblog.exception;

import com.myblog11.myblog.payload.Errormsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Errormsg> ResourceNotFoundException(
            ResourceNotFoundException e,
            WebRequest request
    ){
        Errormsg msg = new Errormsg(e.getMessage(),new Date(),request.getDescription(true));
        return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
