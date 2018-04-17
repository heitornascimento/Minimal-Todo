package com.app.sumup.payment.domain;

import com.app.sumup.payment.domain.exception.SumUpInvalidParamReceiptException;
import com.app.sumup.payment.domain.interactor.ReceiptUseCase;
import com.app.sumup.payment.domain.model.ReceiptParam;
import com.app.sumup.payment.domain.repository.ReceiptRepository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.Scheduler;

@RunWith(MockitoJUnitRunner.class)
public class ReceiptUseCaseTest {

    @Mock
    ReceiptRepository receiptRepository;

    ReceiptUseCase receiptUseCase;

    @Mock
    Scheduler mThreadExecutor;

    @Mock
    Scheduler mPostExecutor;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        receiptUseCase = new ReceiptUseCase(receiptRepository, mThreadExecutor, mPostExecutor);
    }

    @Test
    public void shouldBuildUseCase() throws SumUpInvalidParamReceiptException {
        ReceiptParam receiptParam = new ReceiptParam("123", "123");
        receiptUseCase.buildObservable(receiptParam);
        Mockito.verify(receiptRepository).loadReceipt(receiptParam);
    }

    @Test
    public void shouldFailedBuildUseCaseTransactionCode() throws SumUpInvalidParamReceiptException {
        expectedException.expect(SumUpInvalidParamReceiptException.class);
        ReceiptParam receiptParam = new ReceiptParam("", "123");
        receiptUseCase.buildObservable(receiptParam);
    }


    @Test
    public void shouldFailedBuildUseCaseMerchantCode() throws SumUpInvalidParamReceiptException {
        expectedException.expect(SumUpInvalidParamReceiptException.class);
        ReceiptParam receiptParam = new ReceiptParam("123", null);
        receiptUseCase.buildObservable(receiptParam);
    }


}
