package com.example.avjindersinghsekhon.minimaltodo.SumUp.DI.Module;


import android.content.Context;

import com.app.sumup.payment.PaymentExecutorImpl;
import com.app.sumup.payment.domain.interactor.ReceiptUseCase;
import com.app.sumup.payment.domain.repository.ReceiptRepository;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.DI.Annotation.ApplicationContext;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.Presenter.PaymentPresenter;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.Presenter.ReceiptPresenter;
import com.example.avjindersinghsekhon.minimaltodo.SumUpApplication;
import com.sumup.data.Injector;
import com.sumup.data.api.SumUpEndpoint;
import com.sumup.data.api.SumUpService;
import com.sumup.data.repository.ReceiptRepositoryImpl;

import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class ApplicationModule {

    @Provides
    @ApplicationContext
    public Context provideContext(SumUpApplication application) {
        return application.getApplicationContext();
    }

    @Provides
    public SumUpService provideSumUpService() {
        return Injector.provideSumUpService();
    }

    @Provides
    public SumUpEndpoint provideSumUpEndpoint(SumUpService sumUpService) {
        return new SumUpEndpoint(sumUpService);
    }

    @Provides
    public ReceiptRepository provideReceiptRepository(SumUpEndpoint endpoint) {
        return new ReceiptRepositoryImpl(endpoint);
    }

    @Provides
    public ReceiptUseCase provideReceiptUseCase(ReceiptRepository receiptRepository) {
        return new ReceiptUseCase(receiptRepository, Schedulers.io(), AndroidSchedulers.mainThread());
    }

    @Provides
    public ReceiptPresenter provideReceiptPresenter(ReceiptUseCase receiptUseCase) {
        return new ReceiptPresenter(receiptUseCase);
    }

    @Provides
    public PaymentPresenter providePaymentPresenter() {
        PaymentExecutorImpl paymentExecutor = new PaymentExecutorImpl();
        return new PaymentPresenter(paymentExecutor);
    }


}
