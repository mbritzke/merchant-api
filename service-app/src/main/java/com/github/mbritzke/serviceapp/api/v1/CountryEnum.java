package com.github.mbritzke.serviceapp.api.v1;

public enum CountryEnum {
    USA("usd"),
    CAN("cad");

    public final String currency;

    private CountryEnum(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
