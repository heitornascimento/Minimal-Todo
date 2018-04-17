package com.sumup.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sumup.data.IdlingResources;
import com.sumup.data.api.SumUpService;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injector {


    private static final int TIMEOUT_VALUE = 60;
    private static final TimeUnit TIMEOUT_UNIT = TimeUnit.SECONDS;

    public static OkHttpClient okHttpClient;

    private static Retrofit provideRetrofit(String baseUrl) {

        OkHttpClient client = getHttpClient();

        if(BuildConfig.DEBUG){
            IdlingResources.registerOkHttp(client);
        }

        return new Retrofit.Builder().baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private static OkHttpClient getHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        okHttpClient = new OkHttpClient.Builder().connectTimeout(TIMEOUT_VALUE, TIMEOUT_UNIT)
                .writeTimeout(TIMEOUT_VALUE, TIMEOUT_UNIT)
                .readTimeout(TIMEOUT_VALUE, TIMEOUT_UNIT).addInterceptor(interceptor).build();
        return okHttpClient;
    }

    public static Gson getGson() {
        // Creates the json object which will manage the information received
        GsonBuilder builder = new GsonBuilder();
        return builder.create();
    }

    public static SumUpService provideSumUpService() {
        return provideRetrofit(BuildConfig.SUMUP_URL).create(SumUpService.class);
    }
}
