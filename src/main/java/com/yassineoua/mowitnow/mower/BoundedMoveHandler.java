package com.yassineoua.mowitnow.mower;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoundedMoveHandler implements MoveHandler {

    private int maxX;

    private int maxY;

    @Override
    public void move(Mower mower, MoveAction action) {
        switch (action) {
            case MOVE_FORWARD:
                moveForward(mower);
                break;
            case TURN_LEFT:
                mower.turnLeft();
                break;
            case TURN_RIGHT:
                mower.turnRight();
                break;
        }
    }

    private void moveForward(Mower mower) {
        if (mower.getOrientation() == Orientation.W && mower.getX() > 0) {
            mower.moveForward();
        } else if (mower.getOrientation() == Orientation.E && mower.getX() < maxX) {
            mower.moveForward();
        } else if (mower.getOrientation() == Orientation.N && mower.getY() < maxY) {
            mower.moveForward();
        } else if (mower.getOrientation() == Orientation.S && mower.getY() > 0) {
            mower.moveForward();
        }
    }
}
