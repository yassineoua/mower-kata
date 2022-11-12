package com.yassineoua.mowitnow.mower;

import com.yassineoua.mowitnow.exceptions.BadCoordinatesException;
import com.yassineoua.mowitnow.utils.PreconditionUtils;
import lombok.Getter;

public class Position implements Cloneable {

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
        if ((x + dx) < 0) {
            throwIllegalOperation();
            return;
        }
        this.x += dx;
    }


    public void translateY(int dy) {
        if ((y + dy) < 0) {
            throwIllegalOperation();
        }
        this.y += dy;
    }

    private void throwIllegalOperation() {
        throw new IllegalStateException("invalid translation");
    }

    public void orient(Orientation orientation) {
        PreconditionUtils.requiredArgument(orientation, "orientation should be not null");
        this.orientation = orientation;
    }

}
