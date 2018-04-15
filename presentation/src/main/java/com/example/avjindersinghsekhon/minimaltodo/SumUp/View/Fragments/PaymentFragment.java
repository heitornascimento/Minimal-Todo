package com.example.avjindersinghsekhon.minimaltodo.SumUp.View.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultFragment;
import com.example.avjindersinghsekhon.minimaltodo.R;

import static android.content.Context.INPUT_METHOD_SERVICE;


public class PaymentFragment extends AppDefaultFragment {

    @Override
    protected int layoutRes() {
       return R.layout.fragment_payment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        InputMethodManager imm =
                (InputMethodManager) this.getActivity().getSystemService(INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public static PaymentFragment newInstance() {
        return new PaymentFragment();
    }
}
