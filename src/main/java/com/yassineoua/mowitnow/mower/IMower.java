package com.yassineoua.mowitnow.mower;

public interface IMower {

    void turnLeft();

    void turnRight();

    void moveForward();

    int getX();

    int getY();

    Orientation getOrientation();
}
