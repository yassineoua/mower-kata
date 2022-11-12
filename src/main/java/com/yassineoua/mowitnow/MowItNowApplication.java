package com.yassineoua.mowitnow;

import com.yassineoua.mowitnow.field.FileBasedLawnFieldBuilder;
import com.yassineoua.mowitnow.field.LawnField;

import java.util.Objects;
import java.util.stream.Collectors;

public class MowItNowApplication {

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("file name is required");
        }

        LawnField lawnField = new FileBasedLawnFieldBuilder(args[0]).build();

        lawnField.mow();

        String mowersPositions = lawnField.getMowers().stream()
                .map(Objects::toString)
                .collect(Collectors.joining(" "));

        System.out.println(mowersPositions);
    }
}
