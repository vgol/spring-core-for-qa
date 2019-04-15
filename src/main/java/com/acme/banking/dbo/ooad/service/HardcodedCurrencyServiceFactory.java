package com.acme.banking.dbo.ooad.service;

public class HardcodedCurrencyServiceFactory {
    public static CurrencyService create() {
        return new NostalgieCurrencyService(xchangeRate);
    }
}
