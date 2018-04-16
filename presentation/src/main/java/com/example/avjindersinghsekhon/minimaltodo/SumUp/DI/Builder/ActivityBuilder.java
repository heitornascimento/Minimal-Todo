package com.example.avjindersinghsekhon.minimaltodo.SumUp.DI.Builder;

import com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoActivity;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.View.Activity.ReceiptDetailsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract ReceiptDetailsActivity bindReceiptDetailsctivity();

    @ContributesAndroidInjector
    abstract AddToDoActivity bindAddToDoActivity();

}
