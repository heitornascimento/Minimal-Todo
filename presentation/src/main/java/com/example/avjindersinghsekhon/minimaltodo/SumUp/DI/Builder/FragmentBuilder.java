package com.example.avjindersinghsekhon.minimaltodo.SumUp.DI.Builder;

import com.example.avjindersinghsekhon.minimaltodo.SumUp.PaymentFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract  class FragmentBuilder {

    @ContributesAndroidInjector
    abstract PaymentFragment bindFragment();

}
