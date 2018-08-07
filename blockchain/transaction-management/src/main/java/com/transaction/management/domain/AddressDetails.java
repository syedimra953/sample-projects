package com.transaction.management.domain;

import java.math.BigInteger;

public class AddressDetails {

    private String hash160;
    private String address;
    private Transaction[] txs;
    private int n_tx;
    private BigInteger total_received = BigInteger.ZERO;
    private BigInteger total_sent = BigInteger.ZERO;
    private BigInteger final_balance = BigInteger.ZERO;

    public BigInteger getFinal_balance() {
        return final_balance;
    }

    public void setFinal_balance(BigInteger final_balance) {
        this.final_balance = final_balance;
    }

    public BigInteger getTotal_received() {
        return total_received;
    }

    public void setTotal_received(BigInteger total_received) {
        this.total_received = total_received;
    }

    public BigInteger getTotal_sent() {
        return total_sent;
    }

    public void setTotal_sent(BigInteger total_sent) {
        this.total_sent = total_sent;
    }

    public int getN_tx() {
        return n_tx;
    }

    public void setN_tx(int n_tx) {
        this.n_tx = n_tx;
    }

    public Transaction[] getTxs() {
        return txs;
    }

    public void setTxs(Transaction[] txs) {
        this.txs = txs;
    }

    public String getHash160() {
        return hash160;
    }

    public void setHash160(String hash160) {
        this.hash160 = hash160;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
