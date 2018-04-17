package com.example.avjindersinghsekhon.minimaltodo;

import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.avjindersinghsekhon.minimaltodo.SumUp.DI.Component.DaggerApplicationComponent;
import com.sumup.merchant.api.SumUpState;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


public class SumUpApplication extends MultiDexApplication implements HasActivityInjector{


    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SumUpState.init(this);
        DaggerApplicationComponent.builder()
                .application(this).build().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
