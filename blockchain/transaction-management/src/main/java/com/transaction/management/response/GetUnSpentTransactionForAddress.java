package com.transaction.management.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GetUnSpentTransactionForAddress {

    private List<TransactionResponse> outputs = new ArrayList<>();

    public List<TransactionResponse> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<TransactionResponse> outputs) {
        this.outputs = outputs;
    }

    @Override
    public String toString() {
        return "GetUnSpentTransactionForAddress{" +
                "outputs=" + outputs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetUnSpentTransactionForAddress that = (GetUnSpentTransactionForAddress) o;
        return Objects.equals(outputs, that.outputs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(outputs);
    }
}
