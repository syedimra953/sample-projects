package com.transaction.management.controllers;

import com.transaction.management.TransactionManagementSystemApplication;
import com.transaction.management.response.TransactionResponse;
import com.transaction.management.service.TransactionManagerServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import java.util.List;

import static org.junit.Assert.*;

public class TransactionManagementControllerTest {

    @Autowired
    private TransactionManagerServiceImpl trxService;

    @Before
    public void setUp(){
        SpringApplication.run(TransactionManagementSystemApplication.class);
    }

    @Test
    public void fetchTransactiionsForAddress() {
        List<TransactionResponse> transactionResponses = trxService.getUnSpentTransactionsForAddress("");
        assertEquals(2, transactionResponses.size());
        assertEquals("099a125024b3bc73d3d917460be3c87482bc65244781c4c14f9bb1ecc5f8e2dc", transactionResponses.get(0).getTx_hash());
    }
}