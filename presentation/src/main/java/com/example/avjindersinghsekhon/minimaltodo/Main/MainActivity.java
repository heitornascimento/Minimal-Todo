package com.example.avjindersinghsekhon.minimaltodo.Main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.app.sumup.payment.PaymentExecutorImpl;
import com.app.sumup.payment.entity.PaymentParam;
import com.example.avjindersinghsekhon.minimaltodo.About.AboutActivity;
import com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultActivity;
import com.example.avjindersinghsekhon.minimaltodo.R;
import com.example.avjindersinghsekhon.minimaltodo.Settings.SettingsActivity;
import com.sumup.merchant.api.SumUpAPI;
import com.sumup.merchant.api.SumUpPayment;

import java.math.BigDecimal;
import java.util.UUID;

public class MainActivity extends AppDefaultActivity {


    private static final String KEY = "b18d7ae1-455d-4a58-8299-0e684c60c51c";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        //SumUpAPI.logout();


//        SumUpLogin login =
//                SumUpLogin.builder("b18d7ae1-455d-4a58-8299-0e684c60c51c").build();
//
//        SumUpAPI.openLoginActivity(MainActivity.this, login ,1);
//


    }


    @Override
    protected void onResume() {
        super.onResume();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                 pay();
//
//                Intent payIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(
//                        "sumupmerchant://pay/1.0"
//                                + "?affiliate-key=" + KEY + ""
//                                + "&app-id=com.avjindersinghsekhon.minimaltodo"
//                                + "&amount=1.23"
//                                + "&currency=BRL"
//                                + "&title=Taxi Ride"
//                                + "&receipt-mobilephone=+3531234567890"
//                                + "&receipt-email=customer@mail.com"
//                                + "&foreign-tx-id=" + UUID.randomUUID().toString()
//                                // optional: skip the success screen
//                                + "&skip-screen-success=true"
//                                + "&callback=mycallbackscheme://result"));

                // startActivity(payIntent);


            }
        }, 300);




    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        //SumUpAPI.Response.ResultCode.
//        Log.i("sumup", "requet " + requestCode + " result code " + resultCode);
//        //if(requestCode == 1 && resultCode == SumUpAPI.Response.ResultCode.SUCCESSFUL){
//        pay();
//        //settings();
//        //}
//    }

    private void pay() {

        PaymentExecutorImpl paymentExecutor = new PaymentExecutorImpl();
        PaymentParam paymentParam = new
                PaymentParam(2.4d, "ad", "ads");
        paymentExecutor.pay(MainActivity.this, paymentParam);


//        SumUpPayment payment = SumUpPayment.builder()
//                // mandatory parameters
//                //mandatory parameters
//                // Please go to https://me.sumup.com/developers to get your Affiliate Key by entering the application ID of your app. (e.g. com.sumup.sdksampleapp)
//                .affiliateKey("b18d7ae1-455d-4a58-8299-0e684c60c51c")
//                .productAmount(1.23)
//                .currency(SumUpPayment.Currency.EUR)
//                // optional: add details
//                .productTitle("Taxi Ride")
//                .receiptEmail("customer@mail.com")
//                .receiptSMS("+3531234567890")
//                // optional: Add metadata
//                .addAdditionalInfo("AccountId", "taxi0334")
//                .addAdditionalInfo("From", "Paris")
//                .addAdditionalInfo("To", "Berlin")
//                //optional: foreign transaction ID, must be unique!
//                .foreignTransactionId(UUID.randomUUID().toString())  // can not exceed 128 chars
//                // optional: skip the success screen
//                .skipSuccessScreen()
//                .build();
//
//
//        SumUpAPI.openPaymentActivity(MainActivity.this, payment, 2);

    }

    private void settings() {
        //SumUpAPI.openPaymentSettingsActivity(MainActivity.this, 3);
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

}


