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
import com.example.avjindersinghsekhon.minimaltodo.Utility.DateUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
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

    @BindView(R.id.business_name)
    TextView mBusinessName;

    @BindView(R.id.transaction_code)
    TextView mTransactionCode;

    @BindView(R.id.total_amount_value)
    TextView mTotalAmount;

    @BindView(R.id.receipt_date)
    TextView mInvoiceDate;

    @BindView(R.id.loading)
    ProgressBar mLoading;

    @BindView(R.id.main_cointainer)
    CoordinatorLayout mMainContainer;

    @BindView(R.id.products)
    RecyclerView mRVProducts;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;


    List<Product> products = new ArrayList<>();
    ProductsAdapter mProductAdapter;
    Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_details);
        mUnbinder = ButterKnife.bind(this);

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
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();

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

        String date = DateUtils.parseDate(paymentReceipt.getTransactionData().getTimeStamp());
        mInvoiceDate.setText(date);


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
