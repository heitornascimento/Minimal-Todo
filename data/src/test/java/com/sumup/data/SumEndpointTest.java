package com.sumup.data;


import com.app.sumup.payment.domain.model.ReceiptParam;
import com.sumup.data.api.SumUpEndpoint;
import com.sumup.data.api.SumUpService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SumEndpointTest {


    @Mock
    SumUpService sumUpService;

    SumUpEndpoint mSumUpEndpoint;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mSumUpEndpoint = new SumUpEndpoint(sumUpService);
    }

    @Test
    public void shouldCreateService(){
        mSumUpEndpoint.loadReceipt("123", "123");
        Mockito.verify(sumUpService)
                .loadReceipt(Matchers.eq("123"), Matchers.eq("123"));
    }

}
