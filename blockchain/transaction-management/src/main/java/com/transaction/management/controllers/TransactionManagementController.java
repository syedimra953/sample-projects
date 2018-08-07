package com.transaction.management.controllers;

import com.transaction.management.response.GetUnSpentTransactionForAddress;
import com.transaction.management.response.TransactionResponse;
import com.transaction.management.service.TransactionManagerServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller - SpringBoot Main class invokes this
 * </p>
 * <p>
 * @author Syed Imran
 * @version 1.0
 */

@RestController
@EnableAutoConfiguration
public class TransactionManagementController {

    private static final Logger LOGGER = LogManager.getLogger(TransactionManagementController.class.getName());
    private static final String ADDRESS_PATH_STR = "/{address}";

    @Autowired
    private TransactionManagerServiceImpl trxService;

    @RequestMapping(value = ADDRESS_PATH_STR, method = RequestMethod.GET)
    public GetUnSpentTransactionForAddress fetchTransactionsForAddress(@PathVariable("address") String address) {

        LOGGER.debug("In fetchTransactionsForAddress for address : " + address);
        List<TransactionResponse> transactionResponses = trxService.getUnSpentTransactionsForAddress(address);
        GetUnSpentTransactionForAddress unSpentTransactionAddress = new GetUnSpentTransactionForAddress();
        unSpentTransactionAddress.setOutputs(transactionResponses);
        return unSpentTransactionAddress;
    }
}
