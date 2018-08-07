package com.transaction.management.response;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Response object for getUnSpentTransactionsForAddress
 *
 */

public class TransactionResponse{

    private BigInteger value;
    private String tx_hash;
    private int output_idx;

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    public String getTx_hash() {
        return tx_hash;
    }

    public void setTx_hash(String tx_hash) {
        this.tx_hash = tx_hash;
    }

    public int getOutput_idx() {
        return output_idx;
    }

    public void setOutput_idx(int output_idx) {
        this.output_idx = output_idx;
    }


    @Override
    public String toString() {
        return "TransactionResponse{" +
                "value='" + value + '\'' +
                ", tx_hash='" + tx_hash + '\'' +
                ", output_idx=" + output_idx +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionResponse that = (TransactionResponse) o;
        return output_idx == that.output_idx &&
                Objects.equals(value, that.value) &&
                Objects.equals(tx_hash, that.tx_hash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, tx_hash, output_idx);
    }

}
