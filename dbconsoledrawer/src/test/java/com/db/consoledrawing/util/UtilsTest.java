package com.db.consoledrawing.util;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class UtilsTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void toPositiveInt() {
        assertEquals(Utils.toPositiveInt("11"), 11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void toPositiveInt2() {
        Utils.toPositiveInt("0");
    }

    @Test(expected = NumberFormatException.class)
    public void toPositiveInt3() {
        Utils.toPositiveInt("aa");
    }

    @Test
    public void shouldAllPositive() {
        Utils.shouldAllPositive(1, 2, 3, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldAllPositive2() {
        Utils.shouldAllPositive(1, -2, 3, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldAllPositive3() {
        Utils.shouldAllPositive(1, 2, 0, 4);
    }

    @Test
    public void shouldAllNonNegative2() {
        Utils.shouldAllPositive(1, 2, 3, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldAllNonNegative3() {
        Utils.shouldAllPositive(1, -2, 3, 4);
    }

}