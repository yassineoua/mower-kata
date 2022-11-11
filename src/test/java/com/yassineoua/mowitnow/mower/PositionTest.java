package com.yassineoua.mowitnow.mower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {

    @ParameterizedTest(name = "throw exception when x = {0} and y = {1} ")
    @CsvSource({"-1, 2", "3, -4", "-5, -5"})
    void shouldThrowExceptionWhenCoordinatesAreNegatives(int x, int y) {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            new Position(x, y, Orientation.N);
        });
    }

    @ParameterizedTest(name = "from (2, 2) to ({0}, {1}) when dx = {2}")
    @CsvSource({"3, 2, 1", "1, 2, -1", "2, 2, 0"})
    void testNewPositionWhenTranslateX(int expectedX, int expectedY, int dx) {
        Position position = new Position(2, 2, Orientation.N);

        position.translateX(dx);

        assertCoordinates(expectedX, expectedY, position);
    }

    @Test
    void shouldThrowExceptionWhenTranslateXResultIsNegative() {
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> {
            new Position(1, 1, Orientation.N).translateX(-2);
        });
    }

    @ParameterizedTest(name = "from (2, 2) to ({0}, {1}) when dx = {2}")
    @CsvSource({"2, 3, 1", "2, 1, -1", "2, 2, 0"})
    void testNewPositionWhenTranslateY(int expectedX, int expectedY, int dy) {
        Position position = new Position(2, 2, Orientation.N);

        position.translateY(dy);

        assertCoordinates(expectedX, expectedY, position);
    }

    @Test
    void shouldThrowExceptionWhenTranslateYResultIsNegative() {
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> {
            new Position(1, 1, Orientation.N).translateY(-2);
        });
    }

    @Test
    void shouldThrowExceptionWhenOrientationIsNull() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            new Position(3, 5, Orientation.N)
                    .orient(null);
        });
    }

    @ParameterizedTest(name = "from (3,5,{0}) to (3, 5, {1}) when orient position to {1}")
    @CsvSource({"N, W", "N, S", "W, E", "S, N"})
    void testNewOrientationWhenOrient(String actualOrientation, String expectedOrientation) {
        Position position = new Position(3, 5, Orientation.valueOf(actualOrientation));

        position.orient(Orientation.valueOf(expectedOrientation));

        Assertions.assertEquals(expectedOrientation, position.getOrientation().toString());
    }

    private void assertCoordinates(int expectedX, int expectedY, Position position) {
        Assertions.assertEquals(expectedX, position.getX());
        Assertions.assertEquals(expectedY, position.getY());
    }

}
