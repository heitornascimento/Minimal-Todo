package com.example.avjindersinghsekhon.minimaltodo.SumUp.Presenter;

import android.util.Log;

import com.app.sumup.payment.domain.interactor.ReceiptUseCase;
import com.app.sumup.payment.domain.model.ReceiptParam;
import com.app.sumup.payment.domain.model.receipt.PaymentReceipt;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.Base.BasePresenter;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;


public class ReceiptPresenter implements BasePresenter {

    private ReceiptUseCase mReceiptUseCase;

    public ReceiptPresenter(ReceiptUseCase receitpUseCase) {
        this.mReceiptUseCase = receitpUseCase;
    }

    public void loadPaymentReceipt(final String transactionCode, final String merchantCode) {

        ReceiptParam receiptParam = new ReceiptParam(transactionCode, merchantCode);
        mReceiptUseCase.buildObservable(receiptParam).subscribe(new SingleObserver() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i("sumup", "disposable "+d);
            }

            @Override
            public void onSuccess(Object o) {
                PaymentReceipt paymentReceipt = (PaymentReceipt) o;
                Log.i("sumup", "success "+paymentReceipt.getTransactionData().getAmount());
            }

            @Override
            public void onError(Throwable e) {
                Log.i("sumup", "error "+e.getMessage());
            }
        });

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }
}
