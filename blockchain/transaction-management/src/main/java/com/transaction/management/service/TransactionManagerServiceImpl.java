package com.transaction.management.service;

import com.transaction.management.domain.AddressDetails;
import com.transaction.management.response.TransactionResponse;
import com.transaction.management.utils.AddressUtil;
import org.glassfish.jersey.client.ClientConfig;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation for Transaction Manager Service
 * </p>
 * <p>
 * @author Syed Imran
 * @version 1.0
 */

@Service
public class TransactionManagerServiceImpl implements TransactionManagerService {

    private static final String URL_STR = "https://blockchain.info/rawaddr/";

    private static final ClientConfig config = new ClientConfig();
    private static final Client client = ClientBuilder.newClient(config);

    @Override
    public List<TransactionResponse> getUnSpentTransactionsForAddress(String address) {

        List<TransactionResponse> trxIds = new ArrayList<>();

        if (AddressUtil.validateAddress(address)){
            WebTarget service = client.target(URL_STR);

            AddressDetails response = service.path(address).request(MediaType.APPLICATION_JSON).get(AddressDetails.class);

            Arrays.stream(response.getTxs()).forEachOrdered(transaction -> Arrays.stream(transaction.getOut()).filter(output -> !output.isSpent()).forEachOrdered(output -> {
                TransactionResponse transactionResponse = new TransactionResponse();
                transactionResponse.setTx_hash(transaction.getHash());
                transactionResponse.setValue(output.getValue());
                transactionResponse.setOutput_idx(output.getN());
                trxIds.add(transactionResponse);
            }));
        }

        return trxIds;
    }
}
