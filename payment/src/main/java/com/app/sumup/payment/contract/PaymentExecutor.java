package com.app.sumup.payment.contract;

import android.app.Activity;

import com.app.sumup.payment.entity.PaymentParam;
import com.app.sumup.payment.exception.SumUpDemoException;

public interface PaymentExecutor {

    void pay(Activity target, PaymentParam param) throws SumUpDemoException;
}
