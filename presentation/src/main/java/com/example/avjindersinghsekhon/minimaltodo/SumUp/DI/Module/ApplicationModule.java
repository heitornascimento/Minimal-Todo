package com.example.avjindersinghsekhon.minimaltodo.SumUp.DI.Module;


import android.content.Context;

import com.app.sumup.payment.domain.interactor.ReceiptUseCase;
import com.app.sumup.payment.domain.repository.ReceiptRepository;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.DI.Annotation.ApplicationContext;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.Presenter.ReceiptPresenter;
import com.example.avjindersinghsekhon.minimaltodo.SumUpApplication;
import com.sumup.data.Injector;
import com.sumup.data.api.SumUpEndpoint;
import com.sumup.data.api.SumUpService;
import com.sumup.data.repository.ReceiptRepositoryImpl;

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

    @Provides
    public ReceiptRepository provideReceitpRepository(SumUpEndpoint endpoint) {
        return new ReceiptRepositoryImpl(endpoint);
    }

    @Provides
    public ReceiptUseCase provideReceiptUseCase(ReceiptRepository receiptRepository) {
        return new ReceiptUseCase(receiptRepository);
    }

    @Provides
    public ReceiptPresenter provideReceitpPresenter(ReceiptUseCase receiptUseCase) {
        return new ReceiptPresenter(receiptUseCase);
    }


}
