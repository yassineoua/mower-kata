package com.yassineoua.mowitnow;

import java.util.List;
import java.util.StringJoiner;

public class Mower {

    private static final List<Orientation> ORIENTATION_ORDER = List.of(Orientation.W, Orientation.N, Orientation.E, Orientation.S);

    private Position position;

    public Mower(Position position) {
        this.position = position;
    }

    public void turnLeft() {
        int currentOrientationIdx = ORIENTATION_ORDER.indexOf(position.getOrientation());
        int newOrientationIdx = currentOrientationIdx - 1;
        newOrientationIdx = newOrientationIdx < 0 ? ORIENTATION_ORDER.size() - 1 : newOrientationIdx;
        position.orient(ORIENTATION_ORDER.get(newOrientationIdx));
    }

    public void turnRight() {
        int currentOrientationIdx = ORIENTATION_ORDER.indexOf(position.getOrientation());
        int newOrientationIdx = currentOrientationIdx + 1;
        newOrientationIdx = newOrientationIdx % ORIENTATION_ORDER.size();
        position.orient(ORIENTATION_ORDER.get(newOrientationIdx));
    }

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

    public Orientation getOrientation() {
        return position.getOrientation();
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
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
