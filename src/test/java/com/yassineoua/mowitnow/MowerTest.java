package com.yassineoua.mowitnow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MowerTest {

    @Test
    void testInitialPositionAndOrientation() {
        Mower mower = new Mower(new Position(1, 2, Orientation.E));
        Assertions.assertEquals("1 2 E", mower.toString());
    }

    @DisplayName("change orientation")
    @ParameterizedTest(name = "from {0} to {1} when mower is turned left")
    @CsvSource({"N, W", "W, S", "S, E", "E, N"})
    void testNewOrientationWhenTurnLeft(String originalOrientation, String expectedOrientation) {
        Mower mower = new Mower(new Position(1, 1, Orientation.valueOf(originalOrientation)));

        mower.turnLeft();

        Assertions.assertEquals(expectedOrientation, mower.getOrientation().toString());
    }

    @DisplayName("change orientation")
    @ParameterizedTest(name = "from {0} to {1} when mower is turned right")
    @CsvSource({"N, E", "W, N", "S, W", "E, S"})
    void testNewOrientationWhenTurnRight(String originalOrientation, String expectedOrientation) {
        Mower mower = new Mower(new Position(1, 1, Orientation.valueOf(originalOrientation)));

        mower.turnRight();

        Assertions.assertEquals(expectedOrientation, mower.getOrientation().toString());
    }

    @DisplayName("move forward to")
    @ParameterizedTest(name = "({0},{1}) when mower is at (3,3,{2})")
    @CsvSource({"3, 4, N", "2, 3, W", "3, 2, S", "4, 3, E"})
    void testMoveForward(int expectedX, int expectedY, String orientation) {
        Mower mower = new Mower(new Position(3, 3, Orientation.valueOf(orientation)));

        mower.moveForward();

        Assertions.assertEquals(expectedX, mower.getX());
        Assertions.assertEquals(expectedY, mower.getY());
    }
}
