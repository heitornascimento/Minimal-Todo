package com.example.avjindersinghsekhon.minimaltodo.SumUp.Presenter;

import android.util.Log;

import com.app.sumup.payment.domain.exception.SumUpInvalidParamReceiptException;
import com.app.sumup.payment.domain.interactor.ReceiptUseCase;
import com.app.sumup.payment.domain.model.ReceiptParam;
import com.app.sumup.payment.domain.model.receipt.PaymentReceipt;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.Base.BasePresenter;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.View.ReceiptView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;


public class ReceiptPresenter implements BasePresenter {

    private ReceiptUseCase mReceiptUseCase;

    private ReceiptView mReceiptView;

    private boolean isResumed = true;

    public ReceiptPresenter(ReceiptUseCase receiptUseCase) {
        this.mReceiptUseCase = receiptUseCase;
    }

    public void setView(ReceiptView receiptView) {
        this.mReceiptView = receiptView;
    }


    public void subscribePaymentReceipt(ReceiptParam receiptParam) throws SumUpInvalidParamReceiptException {
        if (isResumed) {

            if (receiptParam == null) {
                throw new NullPointerException("param is null");
            }

            if (receiptParam.getTransactionCode() == null
                    || receiptParam.getTransactionCode().isEmpty()) {
                throw new NullPointerException("transaction code is null");
            }

            if (receiptParam.getMerchantCode() == null
                    || receiptParam.getMerchantCode().isEmpty()) {
                throw new NullPointerException("merchant code is null");
            }

            mReceiptUseCase.execute(singleObserver, receiptParam);
        }
    }


    SingleObserver singleObserver = new SingleObserver() {
        @Override
        public void onSubscribe(Disposable d) {
            Log.i("sumup", "disposable " + d);
        }

        @Override
        public void onSuccess(Object o) {
            mReceiptView.onSuccess(o);
        }

        @Override
        public void onError(Throwable e) {
            mReceiptView.onError(500, e.getMessage());
        }
    };

    @Override
    public void onResume() {
        isResumed = true;
    }

    @Override
    public void onPause() {
        isResumed = false;
    }
}
