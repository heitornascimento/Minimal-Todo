package com.app.sumup.payment.domain.interactor;

import io.reactivex.Single;

public abstract class UseCase<T, Params> {

   public abstract Single<T> buildObservable(Params params);

}
