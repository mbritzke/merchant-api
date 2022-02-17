package com.github.mbritzke.serviceapp.stub;

import com.github.mbritzke.serviceapp.client.MerchantClientResponse;

public class MerchantClientResponseStub {

    public static MerchantClientResponse create() {
        MerchantClientResponse clientResponse = new MerchantClientResponse();
        clientResponse.setName("Prepaid Mastercard® (Choice)");
        clientResponse.setMinAmount(25.00);
        clientResponse.setMaxAmount(514.00);
        clientResponse.setWebsite("https://help.guusto.com/redeeming-gifts/how-do-i-redeem-a-guusto-gift-for-a-prepaid-mastercard");
        clientResponse.setCountry("usd");
        return clientResponse;
    }
}
