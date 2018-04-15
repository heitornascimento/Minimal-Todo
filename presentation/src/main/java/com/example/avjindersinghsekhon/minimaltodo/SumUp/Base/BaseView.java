package com.example.avjindersinghsekhon.minimaltodo.SumUp.Base;

public interface BaseView<T> {

    void onSuccess(T data);

    void onError(int code, String message);
}
