package com.app.sumup.payment.entity;

import com.sumup.merchant.api.SumUpPayment;

public class PaymentParam {

    private double mProductAmount;
    private String mReceiptEmail;
    private String mReceiptSms;

    public PaymentParam(double productAmount
            , String receiptEmail, String receiptSms) {
        this.mProductAmount = productAmount;
        this.mReceiptEmail = receiptEmail;
        this.mReceiptSms = receiptSms;
    }

    public double getProductAmount() {
        return mProductAmount;
    }


    public String getReceiptEmail() {
        return mReceiptEmail;
    }

    public String getReceiptSms() {
        return mReceiptSms;
    }
}
