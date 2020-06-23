package com.thoughtworks.capacity.gtb.mvc.ErrorException;

public class UserLoginErrorException extends RuntimeException {
    public UserLoginErrorException(String msg) {
        super(msg);
    }
}
