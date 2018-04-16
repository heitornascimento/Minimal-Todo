package com.app.sumup.payment.domain.model.receipt;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("name")
    private String mName;

    @SerializedName("price")
    private double mPrice;

    @SerializedName("quantity")
    private int mQuantity;

    @SerializedName("total_price")
    private double mTotalPrice;


    public String getName() {
        return mName;
    }

    public double getPrice() {
        return mPrice;
    }

    public int getQuantity() {
        return mQuantity;
    }

    public double getTotalPrice() {
        return mTotalPrice;
    }
}
