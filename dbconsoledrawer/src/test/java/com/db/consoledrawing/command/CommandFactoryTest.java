package com.db.consoledrawing.command;

import com.db.consoledrawing.exception.InvalidCommandException;
import com.db.consoledrawing.exception.InvalidCommandParamsException;
import com.db.consoledrawing.interfaces.Command;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandFactoryTest {

    private CommandFactory commandFactory;

    @Before
    public void setUp() {
        commandFactory = new CommandFactory();
    }

    @Test
    public void getCommand() throws Exception {
        commandFactory.getCommand("Q");
    }

    @Test(expected = InvalidCommandException.class)
    public void getCommand2() throws Exception {
        commandFactory.getCommand("A");
    }

    @Test
    public void getCommand3() throws Exception {
        Command command = commandFactory.getCommand("C 20 4");
        Assert.assertThat(command, CoreMatchers.instanceOf(CreateCommand.class));
    }

    @Test(expected = InvalidCommandParamsException.class)
    public void getCommand32() throws Exception {
        commandFactory.getCommand("C 20 -4");
    }

    @Test
    public void getCommand4() throws Exception {
        Command command = commandFactory.getCommand("L 1 2 1 22");
        Assert.assertThat(command, CoreMatchers.instanceOf(DrawLineCommand.class));
    }

    @Test(expected = InvalidCommandParamsException.class)
    public void getCommand42() throws Exception {
        commandFactory.getCommand("L 1 2 1 -22");
    }

    @Test
    public void getCommand5() throws Exception {
        Command command = commandFactory.getCommand("R 14 1 18 3");
        Assert.assertThat(command, CoreMatchers.instanceOf(DrawRectangleCommand.class));
    }

    @Test(expected = InvalidCommandParamsException.class)
    public void getCommand52() throws Exception {
        commandFactory.getCommand("R 14 1 18 -3");
    }

    @Test
    public void getCommand6() throws Exception {
        Command command = commandFactory.getCommand("B 1 3 o");
        Assert.assertThat(command, CoreMatchers.instanceOf(BucketFillCommand.class));
    }

    @Test(expected = InvalidCommandParamsException.class)
    public void getCommand62() throws Exception {
        commandFactory.getCommand("B 1 3 oo");
    }


}