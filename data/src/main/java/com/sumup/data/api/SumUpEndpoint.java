package com.sumup.data.api;

import io.reactivex.Observable;
import io.reactivex.Single;

public class SumUpEndpoint {

    private SumUpService mSumUpService;

    public SumUpEndpoint(SumUpService sumUpService) {
        this.mSumUpService = sumUpService;
    }

    public Observable<Single> loadReceipt(final String transactionCode, final String merchantCode) {
        return mSumUpService.loadReceipt(transactionCode, merchantCode);
    }
}
