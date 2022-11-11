package com.yassineoua.mowitnow.helpers;

import com.yassineoua.mowitnow.mower.IMower;
import com.yassineoua.mowitnow.mower.Mower;
import com.yassineoua.mowitnow.mower.Orientation;
import com.yassineoua.mowitnow.mower.Position;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MowerTestHelper {

    public static IMower createMowerMock(int x, int y, Orientation orientation) {
        IMower mower = mock(IMower.class);

        when(mower.getX()).thenReturn(x);
        when(mower.getY()).thenReturn(y);
        when(mower.getOrientation()).thenReturn(orientation);

        return mower;
    }
}
