package com.acme.banking.dbo.ooad.service;

public class CurrencyServiceFactory {
    public static CurrencyService create() {
        return new NostalgieCurrencyService();
    }
}
