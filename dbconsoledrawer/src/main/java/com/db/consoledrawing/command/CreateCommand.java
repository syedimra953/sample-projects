package com.db.consoledrawing.command;

import com.db.consoledrawing.exception.InvalidCommandParamsException;
import com.db.consoledrawing.interfaces.Command;
import com.db.consoledrawing.util.Utils;

public class CreateCommand implements Command {

    private static String helpMessage = "C w h           Should create a new canvas of width w and height h. w, h should be > 0";
    private int height;
    private int width;

    public CreateCommand(String... params) throws InvalidCommandParamsException {

        if (params.length < 2) {
            throw new InvalidCommandParamsException("Create command expects 2 params", helpMessage);
        }

        try {
            width = Utils.toPositiveInt(params[0]);
            height = Utils.toPositiveInt(params[1]);
        } catch (IllegalArgumentException e) {
            throw new InvalidCommandParamsException("Number must >= 0", helpMessage);
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}