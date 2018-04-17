package com.example.avjindersinghsekhon.minimaltodo;

import com.app.sumup.payment.domain.exception.SumUpInvalidParamReceiptException;
import com.app.sumup.payment.domain.interactor.ReceiptUseCase;
import com.app.sumup.payment.domain.model.ReceiptParam;
import com.app.sumup.payment.domain.model.receipt.PaymentReceipt;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.Presenter.ReceiptPresenter;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.View.ReceiptView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;

@RunWith(MockitoJUnitRunner.class)
public class ReceiptPresenterTest {


    @Mock
    ReceiptUseCase mReceiptUseCase;

    @Mock
    ReceiptView receiptView;

    ReceiptPresenter presenter;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        presenter = new ReceiptPresenter(mReceiptUseCase);
        presenter.setView(receiptView);
    }

    @Test
    public void shouldLoadReceipt() throws SumUpInvalidParamReceiptException {
        ReceiptParam param =
                new ReceiptParam("123", "123");
        Mockito.when(mReceiptUseCase.buildObservable(Matchers.eq(param)))
                .thenReturn(Single.fromObservable(Observable.<PaymentReceipt>empty()));
        presenter.subscribePaymentReceipt(param);

        Mockito.verify(mReceiptUseCase)
                .execute(Matchers.any(SingleObserver.class), Matchers.eq(param));

    }

}
