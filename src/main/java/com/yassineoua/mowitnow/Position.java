package com.yassineoua.mowitnow;

import lombok.Getter;

import java.util.Objects;

public class Position {

    @Getter
    private int x;

    @Getter
    private int y;

    @Getter
    private Orientation orientation;


    public Position(int x, int y, Orientation orientation) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("coordinates must be positive");
        }
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void translateX(int dx) {
        this.x += dx;
    }

    public void translateY(int dy) {
        this.y += dy;
    }

    public void orient(Orientation orientation) {
        if (Objects.isNull(orientation)) {
            throw new IllegalArgumentException("orientation should be not null");
        }
        this.orientation = orientation;
    }

}
