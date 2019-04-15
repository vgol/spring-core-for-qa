package com.acme.banking.dbo.ooad.service;

public class NostalgieCurrencyService implements CurrencyService {
    private int xchangeRate;

    public NostalgieCurrencyService(int xchangeRate) {
        this.xchangeRate = xchangeRate;
    }

    @Override
    public double exchange(double rurAmount) {
        return xchangeRate * rurAmount;
    }
}
