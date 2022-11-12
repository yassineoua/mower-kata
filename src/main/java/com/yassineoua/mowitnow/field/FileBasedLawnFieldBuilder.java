package com.yassineoua.mowitnow.field;

import com.yassineoua.mowitnow.exceptions.MowItNowException;
import com.yassineoua.mowitnow.mower.MoveActions;
import com.yassineoua.mowitnow.mower.Orientation;
import com.yassineoua.mowitnow.mower.Position;
import com.yassineoua.mowitnow.utils.PreconditionUtils;

import java.io.*;
import java.net.URL;

public class FileBasedLawnFieldBuilder implements LawnFieldBuilder {

    private static final String SEPARATOR = " ";
    private String filename;

    public FileBasedLawnFieldBuilder(String filename) {
        PreconditionUtils.requiredArgument(filename, "filename must be not null");
        this.filename = filename;
    }

    @Override
    public LawnField build() {
        String line = readLine();
        if(line == null || line.isBlank() || line.isEmpty()) {
            throw new MowItNowException("file is empty");
        }
        return createLawnFieldFromString(line);
    }

    private LawnField createLawnFieldFromString(String str) {
        String[] parts = str.split(SEPARATOR);
        if (parts.length < 2 || (parts.length - 2) % 4 != 0) {
            throw new MowItNowException("error format");
        }

        LawnField lawnField = new LawnField(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));

        for (int i = 2; i < parts.length; i += 4) {
            int x = Integer.parseInt(parts[i]);
            int y = Integer.parseInt(parts[i + 1]);
            Orientation orientation = Orientation.valueOf(parts[i + 2]);

            lawnField.addMower(new Position(x, y, orientation), MoveActions.of(parts[i + 3]));
        }

        return lawnField;
    }

    private String readLine() {
        URL resource = getClass().getClassLoader().getResource(filename);
        if (resource == null) {
            throw new MowItNowException(new FileNotFoundException(filename));
        }
        File file = new File(resource.getFile());
        try (InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file));
             BufferedReader reader = new BufferedReader(streamReader)) {
            return reader.readLine();
        } catch (IOException e) {
            throw new MowItNowException(e);
        }
    }
}
