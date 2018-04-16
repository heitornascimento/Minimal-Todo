package com.app.sumup.payment;

import android.app.Activity;

import com.app.sumup.payment.contract.PaymentExecutor;
import com.app.sumup.payment.entity.PaymentParam;
import com.sumup.merchant.api.SumUpAPI;
import com.sumup.merchant.api.SumUpPayment;

import java.math.BigDecimal;

public class PaymentExecutorImpl implements PaymentExecutor {


    @Override
    public void pay(Activity target, PaymentParam param)  {

        if (param == null) {
            throw new RuntimeException("param cannot be null");
        }

        SumUpPayment payment = SumUpPayment.builder()
                .total(new BigDecimal(param.getProductAmount()))
                .currency(SumUpPayment.Currency.EUR)
                .build();

        SumUpAPI.checkout(target, payment, 2);


    }
}
