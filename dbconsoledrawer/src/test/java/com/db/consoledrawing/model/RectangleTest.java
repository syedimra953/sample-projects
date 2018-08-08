package com.db.consoledrawing.model;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {
    @Test
    public void create() {
        new Rectangle(1, 2, 1, 3);
    }

    @Test
    public void create7() {
        new Rectangle(1, 2, 3, 4);
    }

    @Test
    public void create2() {
        Rectangle line1 = new Rectangle(1, 2, 1, 3);
        Rectangle line2 = new Rectangle(1, 2, 1, 3);
        Assert.assertEquals(line1, line2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create3() {
        new Rectangle(-1, 2, 1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create4() {
        new Rectangle(1, -2, 1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create5() {
        new Rectangle(1, 2, -1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create6() {
        new Rectangle(1, 2, 1, -2);
    }
}