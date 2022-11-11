package com.yassineoua.mowitnow.mower;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.mockito.Mockito.*;

public class BoundedMoveHandlerTest {


    @Test
    void shouldMoveForwardWhenPositionIsInsideArea() {
        BoundedMoveHandler moveHandler = new BoundedMoveHandler(5, 5);
        Mower mower = createMowerMock(new Position(2, 3, Orientation.N));

        moveHandler.move(mower, MoveAction.MOVE_FORWARD);

        verify(mower, times(1)).moveForward();
    }


    @DisplayName("cannot move forward")
    @ParameterizedTest(name = "when mower is at ({0},{1},{2}) and area boundaries is (5, 5)")
    @CsvSource({"0,2,W", "5,5,E", "2,0,S", "5,5,N"})
    void shouldNotMoveForwardWhenPositionIsOutsideArea(int x, int y, String orientation) {
        BoundedMoveHandler moveHandler = new BoundedMoveHandler(5, 5);
        Mower mower = createMowerMock(new Position(x, y, Orientation.valueOf(orientation)));

        moveHandler.move(mower, MoveAction.MOVE_FORWARD);

        verify(mower, never()).moveForward();
    }

    @Test
    void testTurnLeft() {
        BoundedMoveHandler moveHandler = new BoundedMoveHandler(5, 5);
        Mower mower = createMowerMock(new Position(2, 2, Orientation.N));

        moveHandler.move(mower, MoveAction.TURN_LEFT);

        verify(mower, times(1)).turnLeft();
    }

    @Test
    void testTurnRight() {
        BoundedMoveHandler moveHandler = new BoundedMoveHandler(5, 5);
        Mower mower = createMowerMock(new Position(2, 2, Orientation.N));

        moveHandler.move(mower, MoveAction.TURN_RIGHT);

        verify(mower, times(1)).turnRight();
    }

    private Mower createMowerMock(Position position) {
        Mower mower = mock(Mower.class);

        when(mower.getX()).thenReturn(position.getX());
        when(mower.getY()).thenReturn(position.getY());
        when(mower.getOrientation()).thenReturn(position.getOrientation());

        return mower;
    }

}
