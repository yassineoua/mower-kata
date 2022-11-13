package com.yassineoua.mowitnow.exceptions;

public class InvalidMoveActionException extends MowItNowException {

    public InvalidMoveActionException(char moveOrder) {
        super(String.format("invalid move action '%c'", moveOrder));
    }
}
