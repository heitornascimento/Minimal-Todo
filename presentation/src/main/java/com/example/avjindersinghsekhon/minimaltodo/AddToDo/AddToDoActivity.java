package com.example.avjindersinghsekhon.minimaltodo.AddToDo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultActivity;
import com.example.avjindersinghsekhon.minimaltodo.R;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.View.Fragments.ReceiptFragment;

public class AddToDoActivity extends AppDefaultActivity {
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int contentViewLayoutRes() {
        return R.layout.activity_add_to_do;
    }

    @NonNull
    @Override
    protected Fragment createInitialFragment() {
        return ReceiptFragment.newInstance();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}

