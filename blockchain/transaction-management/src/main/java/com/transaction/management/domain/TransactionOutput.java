package com.transaction.management.domain;

import java.math.BigInteger;

public class TransactionOutput {

    private boolean spent;
    private BigInteger tx_index = BigInteger.ZERO;
    private int type;
    private String addr;
    private BigInteger value = BigInteger.ZERO;
    private int n;
    private String script;

    public boolean isSpent() {
        return spent;
    }

    public void setSpent(boolean spent) {
        this.spent = spent;
    }

    public BigInteger getTx_index() {
        return tx_index;
    }

    public void setTx_index(BigInteger tx_index) {
        this.tx_index = tx_index;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
