package com.example.avjindersinghsekhon.minimaltodo.SumUp.Payment.DI.Module;


import android.content.Context;

import com.example.avjindersinghsekhon.minimaltodo.SumUp.Payment.DI.Annotation.ApplicationContext;
import com.example.avjindersinghsekhon.minimaltodo.SumUpApplication;
import com.sumup.data.Injector;
import com.sumup.data.api.SumUpEndpoint;
import com.sumup.data.api.SumUpService;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Provides
    @ApplicationContext
    public Context provideContext(SumUpApplication application) {
        return application.getApplicationContext();
    }

    @Provides
    public SumUpService provieSumUpService() {
        return Injector.provideSumUpService();
    }

    @Provides
    public SumUpEndpoint proviceSumUpEndpoint(SumUpService sumUpService) {
        return new SumUpEndpoint(sumUpService);
    }

}
