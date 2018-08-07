package com.transaction.management.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddressUtilTest {

    @Test(expected = IllegalArgumentException.class)
    public void emptyNullAddressCheck(){
        AddressUtil.validateAddress("");
    }

    @Test
    public void validateAddress() {

        assertFalse(AddressUtil.validateAddress("asdasdasdsas"));
        assertFalse(AddressUtil.validateAddress("2342342342zcasdsadasdas"));
        assertFalse(AddressUtil.validateAddress("2342342342zcasd$$%%%%%sadasdas"));
        assertTrue(AddressUtil.validateAddress("1Aff4FgrtA1dZDwajmknWTwU2WtwUvfiXa"));
        assertTrue(AddressUtil.validateAddress("1FPeomAmF2ZbKsDpdVTUbdLXoP9ZhQE1uP"));
        assertTrue(AddressUtil.validateAddress("1FZwaxGVtTNCuKDHAQVNZTpGczNzG1zfnd"));

    }
}