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


    public void subscribePaymentReceipt(final String transactionCode, final String merchantCode) throws SumUpInvalidParamReceiptException {

        if (isResumed) {
            ReceiptParam receiptParam = new ReceiptParam(transactionCode, merchantCode);
            mReceiptUseCase.buildObservable(receiptParam).subscribe(new SingleObserver() {
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
            });
        }

    }

    public void setView(ReceiptView receiptView) {
        this.mReceiptView = receiptView;
    }

    @Override
    public void onResume() {
        isResumed = true;
    }

    @Override
    public void onPause() {
        isResumed = false;
    }
}
