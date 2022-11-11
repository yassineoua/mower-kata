package com.yassineoua.mowitnow.mower;

public class ImmutableMower implements IMower {

    private IMower mower;

    private ImmutableMower(IMower mower) {
        this.mower = mower;
    }

    public static ImmutableMower of(IMower mower) {
        return new ImmutableMower(mower);
    }

    @Override
    public void turnLeft() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void turnRight() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void moveForward() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getX() {
        return mower.getX();
    }

    @Override
    public int getY() {
        return mower.getY();
    }

    @Override
    public Orientation getOrientation() {
        return mower.getOrientation();
    }

    @Override
    public String toString() {
        return mower.toString();
    }
}
