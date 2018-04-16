package com.app.sumup.payment;

import android.app.Activity;

import com.app.sumup.payment.contract.LoginSumUp;
import com.sumup.merchant.api.SumUpAPI;

public class SumUpDemoLogin implements LoginSumUp {

    @Override
    public void startAuthentication(Activity target) {
        com.sumup.merchant.api.SumUpLogin sumupLogin = com.sumup.merchant.api.SumUpLogin.builder(BuildConfig.AFFLIATE_CODE).build();
        SumUpAPI.openLoginActivity(target, sumupLogin, 1);
    }
}

