package com.sumup.data.repository;

import com.app.sumup.payment.domain.model.ReceiptParam;
import com.app.sumup.payment.domain.model.receipt.PaymentReceipt;
import com.app.sumup.payment.domain.repository.ReceiptRepository;
import com.sumup.data.api.SumUpEndpoint;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ReceiptRepositoryImpl implements ReceiptRepository {

    private SumUpEndpoint sumUpEndpoint;

    public ReceiptRepositoryImpl(SumUpEndpoint sumUpEndpoint) {
        this.sumUpEndpoint = sumUpEndpoint;
    }

    @Override
    public Single<PaymentReceipt> loadReceipt(ReceiptParam receiptParam) {
        return sumUpEndpoint
                .loadReceipt(receiptParam.getTransactionCode()
                        , receiptParam.getMerchantCode())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
