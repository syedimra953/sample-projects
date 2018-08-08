package com.db.consoledrawing.command;

import com.db.consoledrawing.exception.InvalidCommandParamsException;
import com.db.consoledrawing.interfaces.DrawEntityCommand;
import com.db.consoledrawing.util.Utils;

public class BucketFillCommand implements DrawEntityCommand {

    private static final String helpMessage = "B x y c         Should fill the entire area connected to (x,y) with \"colour\" c. The\n" +
            "                behaviour of this is the same as that of the \"bucket fill\" tool in paint\n" +
            "                programs.";

    private int  x;
    private int  y;
    private char character;

    public BucketFillCommand(String... params) throws InvalidCommandParamsException {

        if (params.length < 3) {
            throw new InvalidCommandParamsException("Bucket fill expects 3 params", helpMessage);
        }
        if (params[2].length() != 1){
            throw new InvalidCommandParamsException("Color character should only be 1 character", helpMessage);
        }
        try {
            x = Utils.toPositiveInt(params[0]);
            y = Utils.toPositiveInt(params[1]);
            character = params[2].charAt(0);
        } catch (IllegalArgumentException e) {
            throw new InvalidCommandParamsException("x or y should be > 0", helpMessage);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getCharacter() {
        return character;
    }

}