package com.example.avjindersinghsekhon.minimaltodo.SumUp.Payment.Presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.app.sumup.payment.PaymentExecutorImpl;
import com.app.sumup.payment.entity.PaymentParam;
import com.app.sumup.payment.exception.SumUpDemoException;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.Payment.Base.BasePresenter;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.Payment.Base.BaseView;

public class PaymentPresenter implements BasePresenter {

    private PaymentExecutorImpl mPaymentExecutor;

    private BaseView mPaymentView;

    private boolean isResume;

    public PaymentPresenter(PaymentExecutorImpl paymentExecutor, BaseView paymentView) {
        this.mPaymentExecutor = paymentExecutor;
        this.mPaymentView = paymentView;
    }

    public void pay(@NonNull Activity target, @NonNull PaymentParam param) {

        if ((param == null) || param.getProductAmount() < 0 ||
                param.getReceiptEmail().isEmpty() || param.getReceiptSms().isEmpty()) {
            mPaymentView.onError(1, "");
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
