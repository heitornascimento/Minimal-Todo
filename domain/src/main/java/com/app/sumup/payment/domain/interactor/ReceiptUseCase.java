package com.app.sumup.payment.domain.interactor;

import com.app.sumup.payment.domain.model.ReceiptParam;
import com.app.sumup.payment.domain.repository.ReceiptRepository;

import io.reactivex.Single;

public class ReceiptUseCase extends UseCase {


    private ReceiptRepository mReceiptRepository;

    public ReceiptUseCase(ReceiptRepository receiptRepository) {
        this.mReceiptRepository = receiptRepository;
    }

    @Override
    public Single buildObservable(Object o) {
        ReceiptParam receiptParam = (ReceiptParam) o;
        return  mReceiptRepository.loadReceipt(receiptParam);
    }
}
