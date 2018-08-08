package com.db.consoledrawing.exception;

public class InvalidCommandParamsException extends Exception {

    private final String help;

    public InvalidCommandParamsException(String message, String _help) {
        super(message);
        help = _help;
    }

    public String getHelpMessage() {
        return help;
    }
}