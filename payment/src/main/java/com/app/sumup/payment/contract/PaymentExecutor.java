package com.app.sumup.payment.contract;

import android.app.Activity;

import com.app.sumup.payment.entity.PaymentParam;

public interface PaymentExecutor {

    void pay(Activity target, PaymentParam param);
}
