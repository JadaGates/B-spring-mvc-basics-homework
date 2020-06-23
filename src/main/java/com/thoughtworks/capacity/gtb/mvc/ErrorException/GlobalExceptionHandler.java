package com.thoughtworks.capacity.gtb.mvc.ErrorException;

import com.thoughtworks.capacity.gtb.mvc.ErrorMsg;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    private int errorCode = 400;

    @ExceptionHandler(UserLoginErrorException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMsg handle(UserLoginErrorException ex) {
        return new ErrorMsg(errorCode, ex.getMessage());
    }

    @ExceptionHandler(UserExistErrorException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMsg handle(UserExistErrorException ex) {
        return new ErrorMsg(errorCode, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMsg handle(MethodArgumentNotValidException ex) {
        return new ErrorMsg(errorCode, ex.getBindingResult().getFieldError().getDefaultMessage());
    }
}
