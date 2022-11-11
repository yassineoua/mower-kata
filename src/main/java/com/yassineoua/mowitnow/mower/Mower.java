package com.yassineoua.mowitnow.mower;

import java.util.List;
import java.util.StringJoiner;

public class Mower implements IMower {

    private static final List<Orientation> ORIENTATION_ORDER = List.of(Orientation.W, Orientation.N, Orientation.E, Orientation.S);

    private Position position;

    public Mower(Position position) {
        this.position = new Position(position.getX(), position.getY(), position.getOrientation());
    }

    @Override
    public void turnLeft() {
        int currentOrientationIdx = ORIENTATION_ORDER.indexOf(position.getOrientation());
        int newOrientationIdx = currentOrientationIdx - 1;
        newOrientationIdx = newOrientationIdx < 0 ? ORIENTATION_ORDER.size() - 1 : newOrientationIdx;
        position.orient(ORIENTATION_ORDER.get(newOrientationIdx));
    }

    @Override
    public void turnRight() {
        int currentOrientationIdx = ORIENTATION_ORDER.indexOf(position.getOrientation());
        int newOrientationIdx = currentOrientationIdx + 1;
        newOrientationIdx = newOrientationIdx % ORIENTATION_ORDER.size();
        position.orient(ORIENTATION_ORDER.get(newOrientationIdx));
    }

    @Override
    public void moveForward() {
        switch (position.getOrientation()) {
            case E:
                position.translateX(1);
                break;
            case N:
                position.translateY(1);
                break;
            case S:
                position.translateY(-1);
                break;
            case W:
                position.translateX(-1);
                break;
        }
    }

    @Override
    public Orientation getOrientation() {
        return position.getOrientation();
    }

    @Override
    public int getX() {
        return position.getX();
    }

    @Override
    public int getY() {
        return position.getY();
    }


    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }

        Mower other = (Mower) o;
        return other.getX() == getX()
                && other.getY() == getY()
                && other.getOrientation() == getOrientation();
    }

    @Override
    public int hashCode() {
        return 31 * getX() * getY() * getOrientation().ordinal();
    }

    @Override
    public String toString() {
        return new StringJoiner(" ")
                .add(String.valueOf(position.getX()))
                .add(String.valueOf(position.getY()))
                .add(position.getOrientation().name())
                .toString();
    }


}
