package com.db.consoledrawing.command;

import com.db.consoledrawing.exception.InvalidCommandParamsException;
import org.junit.Test;

public class BucketFillCommandTest {
    @Test
    public void testCreate() throws InvalidCommandParamsException {
        new BucketFillCommand( "1", "1", "o");
    }

    @Test(expected = InvalidCommandParamsException.class)
    public void testCreate1() throws InvalidCommandParamsException {
        new BucketFillCommand( "-1", "1", "o");
    }

    @Test(expected = InvalidCommandParamsException.class)
    public void testCreate2() throws InvalidCommandParamsException {
        new BucketFillCommand( "1", "-1", "o");
    }

    @Test(expected = InvalidCommandParamsException.class)
    public void testCreate3() throws InvalidCommandParamsException {
        new BucketFillCommand( "1", "1");
    }

    @Test(expected = InvalidCommandParamsException.class)
    public void testCreate4() throws InvalidCommandParamsException {
        new BucketFillCommand( "1");
    }

    @Test(expected = InvalidCommandParamsException.class)
    public void testCreate6() throws InvalidCommandParamsException {
        new BucketFillCommand();
    }


}