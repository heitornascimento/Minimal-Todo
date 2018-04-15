package com.app.sumup.payment.domain.model.receipt;

import com.google.gson.annotations.SerializedName;

public class PaymentReceipt {

    @SerializedName("transaction_data")
    private TransactionData mTransactionData;

    public TransactionData getTransactionData() {
        return mTransactionData;
    }

    public void setTransactionData(TransactionData mTransactionData) {
        this.mTransactionData = mTransactionData;
    }
}
