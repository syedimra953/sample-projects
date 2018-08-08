package com.db.consoledrawing.model;

import com.db.consoledrawing.util.Utils;

public class Point {

    public Point(int _x1, int _y1) {
        Utils.shouldAllNonNegative(_x1, _y1);
        this.x = _x1;
        this.y = _y1;
    }

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}