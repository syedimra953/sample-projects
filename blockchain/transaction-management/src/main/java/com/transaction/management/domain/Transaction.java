package com.transaction.management.domain;

import java.math.BigInteger;
import java.sql.Timestamp;

public class Transaction {

    private int ver;
    private String hash;
    private int weight;
    private BigInteger block_height = BigInteger.ZERO;
    private BigInteger tx_index = BigInteger.ZERO;
    private TransactionInput[] inputs;
    private String relayed_by;
    private TransactionOutput[] out;
    private int lock_time;
    private int result;
    private int size;
    private Timestamp time;
    private int vin_sz;
    private int vout_sz;

    public TransactionInput[] getInputs() {
        return inputs;
    }

    public void setInputs(TransactionInput[] inputs) {
        this.inputs = inputs;
    }

    public String getRelayed_by() {
        return relayed_by;
    }

    public void setRelayed_by(String relayed_by) {
        this.relayed_by = relayed_by;
    }

    public TransactionOutput[] getOut() {
        return out;
    }

    public void setOut(TransactionOutput[] out) {
        this.out = out;
    }

    public int getLock_time() {
        return lock_time;
    }

    public void setLock_time(int lock_time) {
        this.lock_time = lock_time;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getVin_sz() {
        return vin_sz;
    }

    public void setVin_sz(int vin_sz) {
        this.vin_sz = vin_sz;
    }

    public int getVout_sz() {
        return vout_sz;
    }

    public void setVout_sz(int vout_sz) {
        this.vout_sz = vout_sz;
    }

    public int getVer() {
        return ver;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public BigInteger getBlock_height() {
        return block_height;
    }

    public void setBlock_height(BigInteger block_height) {
        this.block_height = block_height;
    }

    public BigInteger getTx_index() {
        return tx_index;
    }

    public void setTx_index(BigInteger tx_index) {
        this.tx_index = tx_index;
    }
}
