package com.transaction.management.domain;

import java.math.BigInteger;

public class TransactionInput{

    private BigInteger sequence = BigInteger.ZERO;
    private String witness;
    private TransactionOutput prev_out;
    private String script;

    public BigInteger getSequence() {
        return sequence;
    }

    public void setSequence(BigInteger sequence) {
        this.sequence = sequence;
    }

    public String getWitness() {
        return witness;
    }

    public void setWitness(String witness) {
        this.witness = witness;
    }

    public TransactionOutput getPrev_out() {
        return prev_out;
    }

    public void setPrev_out(TransactionOutput prev_out) {
        this.prev_out = prev_out;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
