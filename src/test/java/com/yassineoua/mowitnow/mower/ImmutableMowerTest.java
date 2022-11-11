package com.yassineoua.mowitnow.mower;

import com.yassineoua.mowitnow.helpers.MowerTestHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImmutableMowerTest {

    @Test
    void testCreateImmutableMower() {
        IMower mower = MowerTestHelper.createMowerMock(0, 4, Orientation.N);

        ImmutableMower immutableMower = ImmutableMower.of(mower);

        Assertions.assertEquals(0, immutableMower.getX());
        Assertions.assertEquals(4, immutableMower.getY());
        Assertions.assertEquals(Orientation.N, immutableMower.getOrientation());
    }

    @Test
    void shouldThrowExceptionWhenTurnLeft() {
        IMower mower = MowerTestHelper.createMowerMock(0, 4, Orientation.N);

        ImmutableMower immutableMower = ImmutableMower.of(mower);

        Assertions.assertThrowsExactly(UnsupportedOperationException.class, immutableMower::turnLeft);
    }

    @Test
    void shouldThrowExceptionWhenTurnRight() {
        IMower mower = MowerTestHelper.createMowerMock(0, 4, Orientation.N);

        ImmutableMower immutableMower = ImmutableMower.of(mower);

        Assertions.assertThrowsExactly(UnsupportedOperationException.class, immutableMower::turnRight);
    }

    @Test
    void shouldThrowExceptionWhenMoveForward() {
        IMower mower = MowerTestHelper.createMowerMock(0, 4, Orientation.N);

        ImmutableMower immutableMower = ImmutableMower.of(mower);

        Assertions.assertThrowsExactly(UnsupportedOperationException.class, immutableMower::moveForward);
    }
}
