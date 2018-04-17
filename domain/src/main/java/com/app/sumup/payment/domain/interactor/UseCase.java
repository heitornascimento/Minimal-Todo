package com.app.sumup.payment.domain.interactor;

import com.app.sumup.payment.domain.exception.SumUpInvalidParamReceiptException;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<T, Params> {


    private Scheduler mThreadExecutor;

    private Scheduler mPostThreadExecutor;

    public UseCase(Scheduler mThreadExecutor, Scheduler postExecution) {
        this.mThreadExecutor = mThreadExecutor;
        this.mPostThreadExecutor = postExecution;
    }

    public abstract Single<T> buildObservable(Params params) throws SumUpInvalidParamReceiptException;


    public void execute(SingleObserver<T> observer, Params params) throws SumUpInvalidParamReceiptException {
        final Single<T> single = this.buildObservable(params)
                .subscribeOn(mThreadExecutor)
                .observeOn(mPostThreadExecutor);

        single.subscribe(observer);

        //addDisposable(observable.subscribeWith(observer));
    }
}
