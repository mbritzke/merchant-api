package com.github.mbritzke.serviceapp.stub;

import com.github.mbritzke.serviceapp.entity.MerchantEntity;

public class MerchantEntityStub {

    public static MerchantEntity create() {
        MerchantEntity entity = new MerchantEntity();
        entity.setName("Prepaid Mastercard® (Choice)");
        entity.setMinAmount(25.00);
        entity.setMaxAmount(514.00);
        entity.setWebsite("https://help.guusto.com/redeeming-gifts/how-do-i-redeem-a-guusto-gift-for-a-prepaid-mastercard");
        entity.setCountry("usd");
        return entity;
    }
}
