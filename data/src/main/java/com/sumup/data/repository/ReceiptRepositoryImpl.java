package com.sumup.data.repository;

import com.app.sumup.payment.domain.model.ReceiptParam;
import com.app.sumup.payment.domain.model.receipt.PaymentReceipt;
import com.app.sumup.payment.domain.repository.ReceiptRepository;
import com.sumup.data.api.SumUpEndpoint;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public class ReceiptRepositoryImpl implements ReceiptRepository {

    private SumUpEndpoint sumUpEndpoint;


    public ReceiptRepositoryImpl(SumUpEndpoint sumUpEndpoint) {
        this.sumUpEndpoint = sumUpEndpoint;
    }

    @Override
    public Single<PaymentReceipt> loadReceipt(ReceiptParam receiptParam) {
        return sumUpEndpoint
                .loadReceipt(receiptParam.getTransactionCode()
                        , receiptParam.getMerchantCode());
    }
}
