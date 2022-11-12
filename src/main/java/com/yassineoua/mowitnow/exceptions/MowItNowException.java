package com.yassineoua.mowitnow.exceptions;

public class MowItNowException extends RuntimeException {
    public MowItNowException(Throwable cause) {
        super(cause);
    }

    public MowItNowException(String message) {
        super(message);
    }
}
