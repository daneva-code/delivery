package com.deliver.exceptions;

public class RestCallException extends RuntimeException {
    public RestCallException (String message) {
        super(message);
    }
}
