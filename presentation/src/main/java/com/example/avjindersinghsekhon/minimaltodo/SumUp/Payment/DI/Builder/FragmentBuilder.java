package com.example.avjindersinghsekhon.minimaltodo.SumUp.Payment.DI.Builder;

import com.example.avjindersinghsekhon.minimaltodo.SumUp.Payment.PaymentFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract  class FragmentBuilder {

    @ContributesAndroidInjector
    abstract PaymentFragment bindFragment();

}
