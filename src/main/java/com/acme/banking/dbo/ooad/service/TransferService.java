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

    //Method DI
    public void save(@Valid @x @y @z Request rq) {

    }

    public void withdraw(Account from, double rurAmount) { //PL/SQL
        //polymorphism
        from.withdraw(currencyService.exchange(rurAmount));
    }
}
