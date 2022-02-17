package com.github.mbritzke.serviceapp.exception;

public class MerchantErrorException extends RuntimeException{

    private static final String MESSAGE = "Error in communication with guusto";

    public MerchantErrorException() {
        super(MESSAGE);
    }
}
