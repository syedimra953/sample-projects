package com.db.consoledrawing.command;

import com.db.consoledrawing.exception.InvalidCommandParamsException;
import com.db.consoledrawing.interfaces.DrawEntityCommand;
import com.db.consoledrawing.util.Utils;

public class DrawLineCommand implements DrawEntityCommand {

    private static final String helpMessage = "L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only\n" +
            "                horizontal or vertical lines are supported. Horizontal and vertical lines\n" +
            "                will be drawn using the 'x' character.";
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public DrawLineCommand(String... params) throws InvalidCommandParamsException {

        if (params.length < 4) {
            throw new InvalidCommandParamsException("Draw line command expects 4 params", helpMessage);
        }

        try {
            x1 = Utils.toPositiveInt(params[0]);
            y1 = Utils.toPositiveInt(params[1]);
            x2 = Utils.toPositiveInt(params[2]);
            y2 = Utils.toPositiveInt(params[3]);
        } catch (IllegalArgumentException e) {
            throw new InvalidCommandParamsException("Number should be > 0", helpMessage);
        }
        if (x1 != x2 && y1 != y2) {
            throw new InvalidCommandParamsException("Draw line does not support diagonal line at the moment", helpMessage);
        }
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

}