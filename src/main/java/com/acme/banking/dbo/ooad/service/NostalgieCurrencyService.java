package com.acme.banking.dbo.ooad.service;

public class NostalgieCurrencyService implements CurrencyService {
    @Override
    public double exchange(double rurAmount) {
        return 30 * rurAmount;
    }
}
