package com.app.sumup.payment.domain.model.receipt;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransactionData {

    @SerializedName("amount")
    private double mAmount;

    @SerializedName("transaction_code")
    private String mTransactionCode;

    @SerializedName("currency")
    private  String mCurrency;

    @SerializedName("timestamp")
    private String mTimeStamp;

    @SerializedName("products")
    private List<Product> mProducts;

    @SerializedName("receipt_no")
    private String mReceiptNum;


    public double getAmount() {
        return mAmount;
    }

    public void setAmount(double mAmount) {
        this.mAmount = mAmount;
    }

    public String getTransactionCode() {
        return mTransactionCode;
    }

    public String getCurrency() {
        return mCurrency;
    }

    public String getTimeStamp() {
        return mTimeStamp;
    }

    public List<Product> getProducts() {
        return mProducts;
    }

    public String getReceiptNum() {
        return mReceiptNum;
    }

    public void setTransactionCode(String mTransactionCode) {
        this.mTransactionCode = mTransactionCode;
    }
}
