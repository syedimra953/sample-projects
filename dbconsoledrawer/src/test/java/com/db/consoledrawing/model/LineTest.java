package com.db.consoledrawing.model;

import org.junit.Assert;
import org.junit.Test;

public class LineTest {
    @Test
    public void create() {
        new Line(1, 2, 1, 3);
    }

    @Test
    public void create2() {
        Line line1 = new Line(1, 2, 1, 3);
        Line line2 = new Line(1, 2, 1, 3);
        Assert.assertEquals(line1, line2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create3() {
        new Line(-1, 2, 1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create4() {
        new Line(1, -2, 1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create5() {
        new Line(1, 2, -1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create6() {
        new Line(1, 2, 1, -2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create7() {
        new Line(1, 2, 3, 4);
    }

}