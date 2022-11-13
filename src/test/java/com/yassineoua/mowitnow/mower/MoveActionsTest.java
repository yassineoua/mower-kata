package com.yassineoua.mowitnow.mower;

import com.yassineoua.mowitnow.exceptions.InvalidMoveActionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MoveActionsTest {

    @Test
    void testCreateMoveActionsWithEmptyString() {
        MoveActions moveActions = MoveActions.of("");

        Assertions.assertFalse(moveActions.hasNext());
    }

    @Test
    void testCreateMoveActionsWithGAAGAAD() {
        MoveActions moveActions = MoveActions.of("GAAGAAD");

        List<MoveAction> expectedActions = List.of(
                MoveAction.TURN_LEFT,
                MoveAction.MOVE_FORWARD,
                MoveAction.MOVE_FORWARD,
                MoveAction.TURN_LEFT,
                MoveAction.MOVE_FORWARD,
                MoveAction.MOVE_FORWARD,
                MoveAction.TURN_RIGHT
        );

        Assertions.assertEquals(expectedActions.size(), moveActions.size());
        expectedActions.forEach(moveAction -> Assertions.assertEquals(moveAction, moveActions.next()));
        Assertions.assertFalse(moveActions.hasNext());
    }

    @Test
    void shouldThrowExceptionWhenMoveActionIsNotValid() {
        Assertions.assertThrowsExactly(InvalidMoveActionException.class, () -> {
            MoveActions.of("AAGADAAXD");
        });
    }
}
