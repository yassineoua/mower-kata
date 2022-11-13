package com.yassineoua.mowitnow.mower;

import com.yassineoua.mowitnow.exceptions.BadCoordinatesException;
import com.yassineoua.mowitnow.exceptions.IllegalMoveException;
import com.yassineoua.mowitnow.utils.PreconditionUtils;
import lombok.Getter;

public class Position {

    @Getter
    private int x;

    @Getter
    private int y;

    @Getter
    private Orientation orientation;


    public Position(int x, int y, Orientation orientation) {
        PreconditionUtils.requiredArgument(orientation, "orientation must be not null");

        if (x < 0 || y < 0) {
            throw new BadCoordinatesException(x, y);
        }

        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void translateX(int dx) {
        int x = this.x + dx;
        if (x < 0) {
            throwIllegalMove(x, this.y);
            return;
        }
        this.x = x;
    }


    public void translateY(int dy) {
        int y = this.y + dy;
        if (y < 0) {
            throwIllegalMove(this.x, y);
        }
        this.y = y;
    }

    private void throwIllegalMove(int x, int y) {
        throw new IllegalMoveException(x, y);
    }

    public void orient(Orientation orientation) {
        PreconditionUtils.requiredArgument(orientation, "orientation should be not null");
        this.orientation = orientation;
    }

}
