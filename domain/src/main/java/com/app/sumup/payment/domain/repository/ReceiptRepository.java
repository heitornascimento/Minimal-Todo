package com.app.sumup.payment.domain.repository;

import com.app.sumup.payment.domain.model.ReceiptParam;
import com.app.sumup.payment.domain.model.receipt.PaymentReceipt;

import io.reactivex.Single;

public interface ReceiptRepository {

    Single<PaymentReceipt> loadReceipt(ReceiptParam receiptParam);
}
