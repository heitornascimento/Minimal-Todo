package com.sumup.data.api;

import com.app.sumup.payment.domain.model.receipt.PaymentReceipt;

import io.reactivex.Single;

public class SumUpEndpoint {

    private SumUpService mSumUpService;

    public SumUpEndpoint(SumUpService sumUpService) {
        this.mSumUpService = sumUpService;
    }

    public Single<PaymentReceipt> loadReceipt(final String transactionCode, final String merchantCode) {
        return mSumUpService.loadReceipt(transactionCode, merchantCode);
    }
}
