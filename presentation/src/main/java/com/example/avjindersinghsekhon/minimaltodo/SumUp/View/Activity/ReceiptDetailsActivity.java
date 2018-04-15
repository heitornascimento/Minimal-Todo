package com.example.avjindersinghsekhon.minimaltodo.SumUp.View.Activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.sumup.payment.domain.exception.SumUpInvalidParamReceiptException;
import com.app.sumup.payment.domain.model.receipt.PaymentReceipt;
import com.app.sumup.payment.domain.model.receipt.Product;
import com.example.avjindersinghsekhon.minimaltodo.R;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.Presenter.ReceiptPresenter;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.View.ProductsAdapter;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.View.ReceiptView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class ReceiptDetailsActivity extends AppCompatActivity
        implements HasSupportFragmentInjector, ReceiptView {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    ReceiptPresenter mReceiptPresenter;

    TextView mBusinessName;
    TextView mTransactionCode;
    TextView mTotalAmount;
    TextView mInvoiceDate;
    ProgressBar mLoading;
    CoordinatorLayout mMainContainer;
    RecyclerView mRVProducts;
    Toolbar mToolbar;


    List<Product> products = new ArrayList<>();
    ProductsAdapter mProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_details);

        mBusinessName = findViewById(R.id.business_name);
        mTransactionCode = findViewById(R.id.transaction_code);
        mTotalAmount = findViewById(R.id.total_amount_value);
        mInvoiceDate = findViewById(R.id.receipt_date);
        mRVProducts = findViewById(R.id.products);
        mLoading = findViewById(R.id.loading);
        mMainContainer = findViewById(R.id.main_cointainer);
        mToolbar = findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setTitle("");
        mToolbar.setNavigationOnClickListener(v -> onBackPressed());


        mMainContainer.setVisibility(View.INVISIBLE);

        mRVProducts.setHasFixedSize(true);
        mRVProducts.setItemAnimator(new DefaultItemAnimator());
        mRVProducts.setLayoutManager(new LinearLayoutManager(this));
        mProductAdapter = new ProductsAdapter(products);
        mRVProducts.setAdapter(mProductAdapter);

        mReceiptPresenter.setView(this);


        try {
            mReceiptPresenter.subscribePaymentReceipt("TCX9APHT2Z", "M4AR96RP");
        } catch (SumUpInvalidParamReceiptException e) {
            onError(500, "");
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        mReceiptPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mReceiptPresenter.onPause();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    public void onSuccess(Object data) {


        mLoading.setVisibility(View.GONE);
        mMainContainer.setVisibility(View.VISIBLE);
        PaymentReceipt paymentReceipt = (PaymentReceipt) data;
        mTotalAmount.setText(String.valueOf(paymentReceipt.getTransactionData().getAmount()));
        mBusinessName.setText(paymentReceipt.getMerchantData().getMerchantProfile().getBusinessName());
        mTransactionCode.setText(paymentReceipt.getTransactionData().getTransactionCode());
        mToolbar.setTitle(paymentReceipt.getTransactionData().getReceiptNum());

        List<Product> products = paymentReceipt.getTransactionData().getProducts();
        mProductAdapter.setData(products);
        mProductAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(int code, String message) {
        mLoading.setVisibility(View.GONE);
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();

    }
}
