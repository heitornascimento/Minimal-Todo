package com.app.sumup.payment.domain.model.receipt;

import com.google.gson.annotations.SerializedName;

public class PaymentReceipt {

    @SerializedName("transaction_data")
    private TransactionData mTransactionData;

    @SerializedName("merchant_data")
    private MerchantData mMerchantData;

    public TransactionData getTransactionData() {
        return mTransactionData;
    }

    public void setTransactionData(TransactionData mTransactionData) {
        this.mTransactionData = mTransactionData;
    }

    public MerchantData getMerchantData() {

        return mMerchantData;
    }

    public void setMerchantData(MerchantData mMerchantData) {
        this.mMerchantData = mMerchantData;
    }
}
