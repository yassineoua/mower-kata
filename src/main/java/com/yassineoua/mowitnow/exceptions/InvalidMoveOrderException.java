package com.yassineoua.mowitnow.exceptions;

public class InvalidMoveOrderException extends MowItNowException {

    public InvalidMoveOrderException(char moveOrder) {
        super(String.format("invalid move action '%c'", moveOrder));
    }
}
