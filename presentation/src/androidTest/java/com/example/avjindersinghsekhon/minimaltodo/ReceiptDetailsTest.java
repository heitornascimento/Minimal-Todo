package com.example.avjindersinghsekhon.minimaltodo;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.avjindersinghsekhon.minimaltodo.SumUp.View.Activity.ReceiptDetailsActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ReceiptDetailsTest {


    @Rule
    public ActivityTestRule<ReceiptDetailsActivity> activityRule =
            new ActivityTestRule<>(ReceiptDetailsActivity.class,
                    true, true);


    @Test
    public void shouldDisplayTotalAmount() {
        Espresso.onView(ViewMatchers.withId(R.id.total_amount_value))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void shouldDisplayTransactionCode() {
        Espresso.onView(ViewMatchers.withId(R.id.transaction_code))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
