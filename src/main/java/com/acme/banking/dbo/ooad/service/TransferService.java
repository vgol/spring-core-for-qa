package com.acme.banking.dbo.ooad.service;

import com.acme.banking.dbo.ooad.domain.Account;

public class TransferService {
    //Creator [GRASP]
    private CurrencyService currencyService = new NostalgieCurrencyService();

    public void withdraw(Account from, double rurAmount) { //PL/SQL
        //polymorphism
        from.withdraw(currencyService.exchange(rurAmount));
    }
}
