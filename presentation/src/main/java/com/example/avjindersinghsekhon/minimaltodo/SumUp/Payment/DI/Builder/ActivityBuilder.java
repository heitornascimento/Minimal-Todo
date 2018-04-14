package com.example.avjindersinghsekhon.minimaltodo.SumUp.Payment.DI.Builder;

import com.example.avjindersinghsekhon.minimaltodo.Main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

}
