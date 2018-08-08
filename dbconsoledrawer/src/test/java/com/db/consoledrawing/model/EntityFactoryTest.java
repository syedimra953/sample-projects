package com.db.consoledrawing.model;

import com.db.consoledrawing.command.BucketFillCommand;
import com.db.consoledrawing.command.DrawLineCommand;
import com.db.consoledrawing.command.DrawRectangleCommand;
import com.db.consoledrawing.exception.InvalidCommandParamsException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EntityFactoryTest {

    private EntityFactory entityFactory;

    @Before
    public void setUp() {
        entityFactory = new EntityFactory();
    }


    @Test
    public void getEntity_DrawLineCommand() throws InvalidCommandParamsException {
        DrawLineCommand drawLineCommand = new DrawLineCommand( "1", "2", "1", "4");
        assertEquals(entityFactory.getEntity(drawLineCommand), new Line(1, 2, 1, 4));
    }

    @Test
    public void getEntity_DrawRectangleCommand() throws InvalidCommandParamsException {
        DrawRectangleCommand drawLineCommand = new DrawRectangleCommand( "1", "2", "3", "4");
        assertEquals(entityFactory.getEntity(drawLineCommand), new Rectangle(1, 2, 3, 4));
    }

    @Test
    public void getEntity_BucketFillCommand() throws InvalidCommandParamsException {
        BucketFillCommand drawLineCommand = new BucketFillCommand( "2", "3", "o");
        assertEquals(entityFactory.getEntity(drawLineCommand), new BucketFill(2, 3, 'o'));
    }

    @Test
    public void getEntity_null() {
        assertEquals(entityFactory.getEntity(null), null);
    }
}