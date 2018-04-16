package com.app.sumup.payment.domain.model.receipt;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MerchantData {

    @SerializedName("merchant_profile")
    private MerchantProfile merchantProfile;


    public MerchantProfile getMerchantProfile() {
        return merchantProfile;
    }

    public void setMerchantProfile(MerchantProfile merchantProfile) {
        this.merchantProfile = merchantProfile;
    }


}
