package com.yassineoua.mowitnow.field;

import com.yassineoua.mowitnow.mower.MoveActions;
import com.yassineoua.mowitnow.mower.Mower;
import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class MowerWithMoveActions {

    private Mower mower;

    private MoveActions moveActions;
}
