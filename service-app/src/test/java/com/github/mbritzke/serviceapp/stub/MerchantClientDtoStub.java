package com.github.mbritzke.serviceapp.stub;

import com.github.mbritzke.serviceapp.client.MerchantClientResponse;

public class MerchantClientDtoStub {

    public static MerchantClientResponse create() {
        MerchantClientResponse dto = new MerchantClientResponse();
        dto.setName("Prepaid Mastercard® (Choice)");
        dto.setMinAmount(25.00);
        dto.setMaxAmount(514.00);
        dto.setWebsite("https://help.guusto.com/redeeming-gifts/how-do-i-redeem-a-guusto-gift-for-a-prepaid-mastercard");
        dto.setCountry("usd");
        return dto;
    }
}
