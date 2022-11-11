package com.yassineoua.mowitnow.mower;

import java.util.ArrayDeque;
import java.util.Queue;

public class MoveActions {

    private Queue<MoveAction> moveActionQueue = new ArrayDeque<>();

    private MoveActions() {
    }

    public static MoveActions of(String strActions) {
        MoveActions moveActions = new MoveActions();

        for (int i = 0; i < strActions.length(); i++) {
            moveActions.moveActionQueue.add(convertToMoveAction(strActions.charAt(i)));
        }

        return moveActions;
    }

    private static MoveAction convertToMoveAction(char c) {
        switch (c) {
            case 'A':
                return MoveAction.MOVE_FORWARD;
            case 'G':
                return MoveAction.TURN_LEFT;
            case 'D':
                return MoveAction.TURN_RIGHT;
            default:
                throw new IllegalArgumentException("Invalid move action '" + c + "'");
        }
    }

    public boolean hasNext() {
        return moveActionQueue.size() != 0;
    }

    public int size() {
        return moveActionQueue.size();
    }

    public MoveAction next() {
        return moveActionQueue.remove();
    }
}
