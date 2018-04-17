package com.sumup.data;

import com.app.sumup.payment.domain.model.ReceiptParam;
import com.app.sumup.payment.domain.model.receipt.PaymentReceipt;
import com.app.sumup.payment.domain.repository.ReceiptRepository;
import com.sumup.data.api.SumUpEndpoint;
import com.sumup.data.repository.ReceiptRepositoryImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;

@RunWith(MockitoJUnitRunner.class)
public class ReceiptRepositoryTest {

    @Mock
    SumUpEndpoint mSumUpEndpoint;
    ReceiptRepository mReceiptRepository;
    ReceiptParam param;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mReceiptRepository = new ReceiptRepositoryImpl(mSumUpEndpoint);
        param = new ReceiptParam("123","123");
    }

    @Test
    public void shouldCallSumUpEndpoint(){
        Mockito.when(mSumUpEndpoint.loadReceipt(Matchers.eq(param.getTransactionCode())
                , Matchers.eq(param.getMerchantCode()))).thenReturn(Single.fromObservable(Observable.<PaymentReceipt>empty()));

        mReceiptRepository.loadReceipt(param);

        Mockito.verify(mSumUpEndpoint).loadReceipt(param.getTransactionCode()
                , param.getMerchantCode());
    }

}
