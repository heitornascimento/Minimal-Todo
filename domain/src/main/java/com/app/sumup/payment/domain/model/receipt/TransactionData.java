package com.app.sumup.payment.domain.model.receipt;

import com.google.gson.annotations.SerializedName;

public class TransactionData {

    @SerializedName("amount")
    private double mAmount;


    public double getAmount() {
        return mAmount;
    }

    public void setAmount(double mAmount) {
        this.mAmount = mAmount;
    }
}
