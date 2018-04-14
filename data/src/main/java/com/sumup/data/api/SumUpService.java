package com.sumup.data.api;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SumUpService {

    @GET("v0.1/receipts/{transaction_code}?mid={merchant_code}")
    Observable<Single> loadReceipt(@Path("transaction_code") String transactionCode
            , @Path("merchant_code") String merchantCode);

}
