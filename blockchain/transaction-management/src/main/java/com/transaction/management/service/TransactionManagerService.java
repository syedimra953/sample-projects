package com.transaction.management.service;

import com.transaction.management.response.TransactionResponse;

import java.util.List;

@FunctionalInterface
public interface TransactionManagerService {
    List<TransactionResponse> getUnSpentTransactionsForAddress(String address);
}
