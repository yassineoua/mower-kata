package com.yassineoua.mowitnow.field;

import com.yassineoua.mowitnow.exceptions.MowItNowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.stream.Collectors;

public class FileLawnFieldReaderTest {

    @Test
    void shouldThrowExceptionWhenFileIsNotExists() {
        FileLawnFieldReader reader = new FileLawnFieldReader("not-exists.txt");

        MowItNowException exception = Assertions.assertThrowsExactly(MowItNowException.class, reader::read);
        Assertions.assertInstanceOf(FileNotFoundException.class, exception.getCause());
    }

    @Test
    void shouldThrowExceptionWhenFileIsEmpty() {
        FileLawnFieldReader reader = new FileLawnFieldReader("empty-file.txt");

        Assertions.assertThrowsExactly(MowItNowException.class, reader::read);
    }

    @Test
    void testCreateLawnField() {
        FileLawnFieldReader reader = new FileLawnFieldReader("field.txt");

        LawnField lawnField = reader.read();

        lawnField.mow();

        String mowersPositions = lawnField.getMowers().stream()
                .map(Objects::toString)
                .collect(Collectors.joining(" "));

        Assertions.assertEquals(2, lawnField.getMowers().size());
        Assertions.assertEquals("1 3 N 5 1 E", mowersPositions);
    }


}
