package com.yassineoua.mowitnow.exceptions;

public class IllegalMoveException extends MowItNowException {
    public IllegalMoveException(int x, int y) {
        super(String.format("Illegal move (%d, %d)", x, y));
    }
}
