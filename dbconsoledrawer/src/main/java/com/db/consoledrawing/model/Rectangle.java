package com.db.consoledrawing.model;

import com.db.consoledrawing.interfaces.Entity;
import com.db.consoledrawing.util.Utils;

public class Rectangle implements Entity {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Rectangle(int _x1, int _y1, int _x2, int _y2) {

        Utils.shouldAllPositive(_x1, _y1, _x2, _y2);
        if ((x1 == x2 && y1 > y2) || (y1 == y2 && x1 > x2)) {
            this.x1 = _x2;
            this.y1 = _y2;
            this.x2 = _x1;
            this.y2 = _y1;
        } else {
            this.x1 = _x1;
            this.y1 = _y1;
            this.x2 = _x2;
            this.y2 = _y2;
        }
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        if (x1 != rectangle.x1) return false;
        if (y1 != rectangle.y1) return false;
        if (x2 != rectangle.x2) return false;
        return y2 == rectangle.y2;
    }

    @Override
    public int hashCode() {
        int result = x1;
        result = 31 * result + y1;
        result = 31 * result + x2;
        result = 31 * result + y2;
        return result;
    }
}