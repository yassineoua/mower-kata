package com.yassineoua.mowitnow.exceptions;

public class BadCoordinatesException extends MowItNowException {
    public BadCoordinatesException(int x, int y) {
        super(String.format("bad coordinates (%d, %d), they should be positives", x, y));
    }
}
