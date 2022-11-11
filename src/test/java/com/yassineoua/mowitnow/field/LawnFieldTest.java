package com.yassineoua.mowitnow.field;

import com.yassineoua.mowitnow.mower.MoveActions;
import com.yassineoua.mowitnow.mower.Orientation;
import com.yassineoua.mowitnow.mower.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LawnFieldTest {

    @Test
    void testCreateEmptyLawnField() {
        LawnField lawnField = new LawnField(5, 5);

        lawnField.mow();

        Assertions.assertTrue(lawnField.isEmpty());
    }


    @Test
    void testCreateLawnFieldAndAddOneMowerAt00NWithoutMove() {
        LawnField lawnField = new LawnField(5, 5);

        lawnField.addMower(new Position(0, 0, Orientation.N), MoveActions.of(""));

        lawnField.mow();

        Assertions.assertEquals(1, lawnField.getMowers().size());
        Assertions.assertEquals("0 0 N", lawnField.getMowers().get(0).toString());
    }


    @Test
    void testCreateLawnFieldAndAddOneMowerWithMoveActions() {
        LawnField lawnField = new LawnField(5, 5);

        lawnField.addMower(new Position(1, 2, Orientation.N), MoveActions.of("GAGAGAGAA"));

        lawnField.mow();

        Assertions.assertEquals(1, lawnField.getMowers().size());
        Assertions.assertEquals("1 3 N", lawnField.getMowers().get(0).toString());
    }


    @Test
    void test() {
        LawnField lawnField = new LawnField(5, 5);

        lawnField.addMower(new Position(1, 2, Orientation.N), MoveActions.of("GAGAGAGAA"));

        lawnField.mow();

        Assertions.assertEquals("1 3 N", lawnField.getMowers().get(0).toString());
    }
}
