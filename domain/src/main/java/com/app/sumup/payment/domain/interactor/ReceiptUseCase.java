package com.app.sumup.payment.domain.interactor;

import com.app.sumup.payment.domain.exception.SumUpInvalidParamReceiptException;
import com.app.sumup.payment.domain.model.ReceiptParam;
import com.app.sumup.payment.domain.repository.ReceiptRepository;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public class ReceiptUseCase extends UseCase {


    private ReceiptRepository mReceiptRepository;


    public ReceiptUseCase(ReceiptRepository receiptRepository
            , Scheduler threadExecutor, Scheduler postExecutor) {
        super(threadExecutor, postExecutor);
        this.mReceiptRepository = receiptRepository;
    }

    @Override
    public Single buildObservable(Object o) throws SumUpInvalidParamReceiptException {
        ReceiptParam receiptParam = (ReceiptParam) o;

        if ((receiptParam.getMerchantCode() == null
                || receiptParam.getMerchantCode().isEmpty())) {
            throw new SumUpInvalidParamReceiptException("Mercant Code cannot be null");
        }

        if ((receiptParam.getTransactionCode() == null
                || receiptParam.getTransactionCode().isEmpty())) {
            throw new SumUpInvalidParamReceiptException("Transaction Code cannot be null");
        }

        return mReceiptRepository.loadReceipt(receiptParam);
    }
}
