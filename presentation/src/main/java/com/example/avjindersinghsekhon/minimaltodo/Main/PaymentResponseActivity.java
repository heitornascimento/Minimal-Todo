package com.example.avjindersinghsekhon.minimaltodo.Main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

import com.example.avjindersinghsekhon.minimaltodo.R;

public class PaymentResponseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_response);

        Intent it = getIntent();
        Uri uri = it.getData();
        Log.i("sumup", " result "+uri.toString());
    }

}
