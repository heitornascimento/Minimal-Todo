package com.sumup.data.api;

import com.app.sumup.payment.domain.model.receipt.PaymentReceipt;

import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SumUpService {

    @GET("v0.1/receipts/{transaction_code}")
    Single<PaymentReceipt> loadReceipt(@Path("transaction_code") String transactionCode
            , @Query("mid") String merchantCode);

}
