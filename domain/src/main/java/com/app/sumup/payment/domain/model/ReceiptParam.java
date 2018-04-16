package com.app.sumup.payment.domain.model;

public class ReceiptParam {

    private String mTransactionCode;

    private String mMerchantCode;

    public ReceiptParam(String transactionCode, String merchantCode) {
        this.mTransactionCode = transactionCode;
        this.mMerchantCode = merchantCode;
    }

    public String getTransactionCode() {
        return mTransactionCode;
    }

    public void setTransactionCode(String mTransactionCode) {
        this.mTransactionCode = mTransactionCode;
    }

    public String getMerchantCode() {
        return mMerchantCode;
    }

    public void setMerchantCode(String mMerchantCode) {
        this.mMerchantCode = mMerchantCode;
    }
}
