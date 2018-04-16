package com.example.avjindersinghsekhon.minimaltodo.SumUp.Presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.app.sumup.payment.PaymentExecutorImpl;
import com.app.sumup.payment.entity.PaymentParam;
import com.app.sumup.payment.exception.SumUpDemoException;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.Base.BasePresenter;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.Base.BaseView;

public class PaymentPresenter implements BasePresenter {

    private PaymentExecutorImpl mPaymentExecutor;


    private boolean isResume = true;

    public PaymentPresenter(PaymentExecutorImpl paymentExecutor) {
        this.mPaymentExecutor = paymentExecutor;
    }


    public void pay(@NonNull Activity target, @NonNull PaymentParam param) throws SumUpDemoException {

        if ((param == null) || param.getProductAmount() < 0 ||
                param.getReceiptEmail().isEmpty() || param.getReceiptSms().isEmpty()) {
            throw new SumUpDemoException("PaymentExecutor cannot be null");
        }

        if (mPaymentExecutor == null) {
            throw new RuntimeException("PaymentExecutor cannot be null");
        }

        if (target == null) {
            throw new RuntimeException("Target Activity cannot be null");
        }

        if (isResume) {
            mPaymentExecutor.pay(target, param);
        }

    }


    @Override
    public void onResume() {
        isResume = true;
    }

    @Override
    public void onPause() {
        isResume = false;
    }
}
