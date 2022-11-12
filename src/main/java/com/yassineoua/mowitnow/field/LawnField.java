package com.yassineoua.mowitnow.field;

import com.yassineoua.mowitnow.mower.*;
import com.yassineoua.mowitnow.utils.PreconditionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LawnField {

    private List<MowerWithMoveActions> mowerWithMoveActions;

    private MoveHandler moveHandler;

    public LawnField(int maxX, int maxY) {
        this.mowerWithMoveActions = new ArrayList<>();
        this.moveHandler = new BoundedMoveHandler(maxX, maxY);
    }

    public boolean isEmpty() {
        return true;
    }

    public void mow() {
        mowerWithMoveActions
                .stream()
                .filter(Predicate.not(MowerWithMoveActions::hasFinished))
                .forEach((mowerWithMoveActions) -> {
                    var mower = mowerWithMoveActions.getMower();
                    var moveActions = mowerWithMoveActions.getMoveActions();
                    while (moveActions.hasNext()) {
                        moveHandler.move(mower, moveActions.next());
                    }
                });
    }

    public void addMower(Position position, MoveActions moveActions) {
        PreconditionUtils.checkNotNull(position, "position must be not null");
        PreconditionUtils.checkNotNull(moveActions, "moveActions must be not null");
        mowerWithMoveActions.add(new MowerWithMoveActions(new Mower(position), moveActions));
    }

    public List<IMower> getMowers() {
        return mowerWithMoveActions.stream()
                .map(MowerWithMoveActions::getMower)
                .map(ImmutableMower::of)
                .collect(Collectors.toUnmodifiableList());
    }


}
