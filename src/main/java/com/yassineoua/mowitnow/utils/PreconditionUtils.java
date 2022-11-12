package com.yassineoua.mowitnow.utils;

public class PreconditionUtils {
    public static void requiredArgument(Object o, String message) {
        if (o == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
