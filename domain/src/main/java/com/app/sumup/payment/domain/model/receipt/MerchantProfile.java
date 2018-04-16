package com.app.sumup.payment.domain.model.receipt;

import com.google.gson.annotations.SerializedName;

public class MerchantProfile {

    @SerializedName("merchant_code")
    private String mMerchantCode;

    @SerializedName("business_name")
    private String mBusinessName;

    @SerializedName("email")
    private String mEmail;

    public String getMerchantCode() {
        return mMerchantCode;
    }

    public void setMerchantCode(String mMerchantCode) {
        this.mMerchantCode = mMerchantCode;
    }

    public String getBusinessName() {
        return mBusinessName;
    }

    public void setBusinessName(String mBusinessName) {
        this.mBusinessName = mBusinessName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}
