package com.example.avjindersinghsekhon.minimaltodo.SumUp.View.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.app.sumup.payment.entity.PaymentParam;
import com.app.sumup.payment.exception.SumUpDemoException;
import com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultFragment;
import com.example.avjindersinghsekhon.minimaltodo.R;
import com.example.avjindersinghsekhon.minimaltodo.SumUp.Presenter.PaymentPresenter;
import com.example.avjindersinghsekhon.minimaltodo.Utility.CustomTextInputLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

import static android.content.Context.INPUT_METHOD_SERVICE;


public class PaymentFragment extends AppDefaultFragment {


    @BindView(R.id.makeToDoFloatingActionButton)
    FloatingActionButton mFABPayment;

    @BindView(R.id.userToDoEditText)
    EditText mAmountValue;

    @BindView(R.id.receiptEmailET)
    EditText mEmail;

    @BindView(R.id.smsET)
    EditText mSms;

    @BindView(R.id.toDoCustomTextInput)
    CustomTextInputLayout mPaymentInputTextLayout;

    @Inject
    PaymentPresenter mPaymentPresenter;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_payment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        mFABPayment.setOnClickListener(v -> {
            startPaymentFlow();
        });

        InputMethodManager imm =
                (InputMethodManager) this.getActivity().getSystemService(INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }


    private void startPaymentFlow() {

        try {
            if (isAmountValid()) {
                double value = new Double(mAmountValue.getText().toString());
                String email = mEmail.getText().toString();
                String sms = mSms.getText().toString();
                PaymentParam paymentParam
                        = new PaymentParam(value, email, sms);

                mPaymentPresenter.pay(getActivity(), paymentParam);
            }
        } catch (SumUpDemoException e) {
            //Handle
        }
    }

    private boolean isAmountValid() {

        String s = mAmountValue.getText().toString();
        boolean isValid = TextUtils.isEmpty(s);
        if (isValid) {
            mPaymentInputTextLayout
                    .setError(getString(R.string.payment_form_value_mandatory));
            return !isValid;
        }

        double value = new Double(mAmountValue.getText().toString());
        isValid = mPaymentPresenter.isValid(value);
        if (!isValid) {
            mPaymentInputTextLayout.setError(getString(R.string.payment_form_value_error));
        }

        if(isValid){
            mPaymentInputTextLayout.setError("");

        }

        return isValid;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    public static PaymentFragment newInstance() {
        return new PaymentFragment();
    }


}
