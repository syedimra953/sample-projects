package com.db.consoledrawing.util;

public class Utils {

    public static int toPositiveInt(String input) throws IllegalArgumentException {
        int num = Integer.parseInt(input);
        throwIllegalArgumentException(num <= 0);

        return num;
    }

    public static void shouldAllPositive(int... numbers) {
        for (int num : numbers) {
            throwIllegalArgumentException(num < 1);
        }
    }

    public static void shouldAllNonNegative(int... numbers) {
        for (int num : numbers) {
            throwIllegalArgumentException(num < 0);
        }
    }


    private static void throwIllegalArgumentException(boolean b) {
        if (b) {
            throw new IllegalArgumentException("Number should be > 0");
        }
    }
}
