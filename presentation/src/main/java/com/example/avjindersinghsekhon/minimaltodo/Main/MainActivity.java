package com.example.avjindersinghsekhon.minimaltodo.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.app.sumup.payment.PaymentExecutorImpl;
import com.app.sumup.payment.SumUpDemoLogin;
import com.app.sumup.payment.entity.PaymentParam;
import com.example.avjindersinghsekhon.minimaltodo.About.AboutActivity;
import com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultActivity;
import com.example.avjindersinghsekhon.minimaltodo.R;
import com.example.avjindersinghsekhon.minimaltodo.Settings.SettingsActivity;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.Base.BaseView;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.Presenter.PaymentPresenter;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.Presenter.ReceiptPresenter;
import com.sumup.data.api.SumUpEndpoint;
import com.sumup.merchant.api.SumUpAPI;

import javax.inject.Inject;

import dagger.Provides;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppDefaultActivity implements BaseView, HasSupportFragmentInjector {

    private static final String KEY = "b18d7ae1-455d-4a58-8299-0e684c60c51c";

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    ReceiptPresenter receiptPresenter;


    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        final android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        SumUpDemoLogin login = new SumUpDemoLogin();
        //login.startAuthentication(this);

        //mPaymentPresenter = new PaymentPresenter(new PaymentExecutorImpl(), this);

    }

    @Override
    protected void onResume() {
        super.onResume();
       // mPaymentPresenter.onResume();

        receiptPresenter.loadPaymentReceipt("TCX9APHT2Z", "M4AR96RP");

    }


    @Override
    protected void onPause() {
        super.onPause();
       // mPaymentPresenter.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("sumup", "requet " + requestCode + " result code " + resultCode);
        if (requestCode == 1 && resultCode == SumUpAPI.Response.ResultCode.SUCCESSFUL) {
            pay();
        }
    }

    /**
     *
     */
    private void pay() {
        PaymentParam paymentParam = new
                PaymentParam(2.4d, "ad", "ads");
       // mPaymentPresenter.pay(MainActivity.this, paymentParam);
    }


    @Override
    protected int contentViewLayoutRes() {
        return R.layout.activity_main;
    }

    @NonNull
    @Override
    protected Fragment createInitialFragment() {
        return MainFragment.newInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.aboutMeMenuItem:
                Intent i = new Intent(this, AboutActivity.class);
                startActivity(i);
                return true;
//            case R.id.switch_themes:
//                if(mTheme == R.style.CustomStyle_DarkTheme){
//                    addThemeToSharedPreferences(LIGHTTHEME);
//                }
//                else{
//                    addThemeToSharedPreferences(DARKTHEME);
//                }
//
////                if(mTheme == R.style.CustomStyle_DarkTheme){
////                    mTheme = R.style.CustomStyle_LightTheme;
////                }
////                else{
////                    mTheme = R.style.CustomStyle_DarkTheme;
////                }
//                this.recreate();
//                return true;
            case R.id.preferences:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onError(int code, String message) {
        //SHOW ALERT
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}


