package com.example.avjindersinghsekhon.minimaltodo.SumUp.DI.Component;

import com.example.avjindersinghsekhon.minimaltodo.SumUp.DI.Builder.ActivityBuilder;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.DI.Builder.FragmentBuilder;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.DI.Module.ApplicationModule;
import com.example.avjindersinghsekhon.minimaltodo.SumUpApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, ApplicationModule.class
        , ActivityBuilder.class, FragmentBuilder.class})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(SumUpApplication application);

        ApplicationComponent build();
    }

    void inject(SumUpApplication sumUpApplication);

}
