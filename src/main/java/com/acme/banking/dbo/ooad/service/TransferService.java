package com.acme.banking.dbo.ooad.service;

import com.acme.banking.dbo.ooad.domain.Account;

public class TransferService {
    //Field DI
    private CurrencyService currencyService;

    //Constructor DI
    public TransferService(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    //Setter DI
    public void setCurrencyService(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    public void withdraw(long fromId, double rurAmount) { //PL/SQL
        Account from = AccountRepo.findById(fromId); //factory
        //polymorphism
        from.withdraw(currencyService.exchange(rurAmount));
        AccountRepo.save(from);
    }
}
