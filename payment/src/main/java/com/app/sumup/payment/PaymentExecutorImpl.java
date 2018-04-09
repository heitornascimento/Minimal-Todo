package com.app.sumup.payment;

import android.app.Activity;

import com.app.sumup.payment.contract.PaymentExecutor;
import com.app.sumup.payment.entity.PaymentParam;
import com.sumup.merchant.api.SumUpAPI;
import com.sumup.merchant.api.SumUpPayment;

import java.util.UUID;

public class PaymentExecutorImpl implements PaymentExecutor {


    @Override
    public void pay(Activity target, PaymentParam param) {
        SumUpPayment payment = SumUpPayment.builder()
                // mandatory parameters
                //mandatory parameters
                // Please go to https://me.sumup.com/developers to get your Affiliate Key by entering the application ID of your app. (e.g. com.sumup.sdksampleapp)
                .affiliateKey("b18d7ae1-455d-4a58-8299-0e684c60c51c")
                .productAmount(param.getProductAmount())
                .currency(SumUpPayment.Currency.BRL)
                // optional: add details
                .productTitle("Taxi Ride")
                .receiptEmail(param.getReceiptEmail())
                .receiptSMS(param.getReceiptSms())
                // optional: Add metadata
                .addAdditionalInfo("AccountId", "taxi0334")
                .addAdditionalInfo("From", "Paris")
                .addAdditionalInfo("To", "Berlin")
                //optional: foreign transaction ID, must be unique!
                .foreignTransactionId(UUID.randomUUID().toString())  // can not exceed 128 chars
                // optional: skip the success screen
                .skipSuccessScreen()
                .build();


        SumUpAPI.openPaymentActivity(target, payment, 2);
    }
}
