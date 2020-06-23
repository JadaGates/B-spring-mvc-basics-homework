package com.thoughtworks.capacity.gtb.mvc.ErrorException;

public class UserExistErrorException extends RuntimeException {
    public UserExistErrorException(String msg) {
        super(msg);
    }
}
