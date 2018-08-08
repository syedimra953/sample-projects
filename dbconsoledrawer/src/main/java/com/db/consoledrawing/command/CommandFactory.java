package com.db.consoledrawing.command;

import com.db.consoledrawing.exception.InvalidCommandException;
import com.db.consoledrawing.exception.InvalidCommandParamsException;
import com.db.consoledrawing.interfaces.Command;

import java.util.Arrays;

public class CommandFactory {

    private static final String EMPTY_SPACE = " ";

    public Command getCommand(String commandLine) throws InvalidCommandException, InvalidCommandParamsException {

        if (commandLine == null && commandLine.isEmpty()) {
            throw new InvalidCommandException();
        }

        commandLine = commandLine.trim().replaceAll(" {2}", EMPTY_SPACE);
        String[] split = commandLine.split(EMPTY_SPACE);
        String mainCommand = split[0].toUpperCase();
        String[] params = Arrays.copyOfRange(split, 1, split.length);

        switch (mainCommand) {
            case "Q":
                return new QuitCommand();
            case "C":
                return new CreateCommand(params);
            case "L":
                return new DrawLineCommand(params);
            case "R":
                return new DrawRectangleCommand(params);
            case "B":
                return new BucketFillCommand(params);
            default:
                throw new InvalidCommandException();
        }
    }
}