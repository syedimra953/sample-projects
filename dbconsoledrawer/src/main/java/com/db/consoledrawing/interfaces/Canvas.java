package com.db.consoledrawing.interfaces;

import com.db.consoledrawing.exception.InvalidEntityException;

public interface Canvas {

    void addEntity(Entity entity) throws InvalidEntityException;
    String render();
}
