package com.yassineoua.mowitnow.field;

import com.yassineoua.mowitnow.exceptions.MowItNowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.stream.Collectors;

public class FileBasedLawnFieldBuilderTest {

    @Test
    void shouldThrowExceptionWhenFileIsNotExists() {
        FileBasedLawnFieldBuilder builder = new FileBasedLawnFieldBuilder("not-exists.txt");

        MowItNowException exception = Assertions.assertThrowsExactly(MowItNowException.class, builder::build);
        Assertions.assertInstanceOf(FileNotFoundException.class, exception.getCause());
    }

    @Test
    void shouldThrowExceptionWhenFileIsEmpty() {
        FileBasedLawnFieldBuilder builder = new FileBasedLawnFieldBuilder("empty-file.txt");

        Assertions.assertThrowsExactly(MowItNowException.class, builder::build);
    }

    @Test
    void testCreateLawnField() {
        FileBasedLawnFieldBuilder builder = new FileBasedLawnFieldBuilder("field.txt");

        LawnField lawnField = builder.build();

        lawnField.mow();

        String mowersPositions = lawnField.getMowers().stream()
                .map(Objects::toString)
                .collect(Collectors.joining(" "));

        Assertions.assertEquals(2, lawnField.getMowers().size());
        Assertions.assertEquals("1 3 N 5 1 E", mowersPositions);
    }


}
