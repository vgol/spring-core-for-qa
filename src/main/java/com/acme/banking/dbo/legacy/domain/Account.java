package com.acme.banking.dbo.legacy.domain;

/** Structure modeled with class: no behavior encapsulated */
public class Account {
    public long id;
    public AccountType type;
    public double amount;
    public double overdraft; //state

    public Account() {
    }

    public Account(long id, AccountType type, double amount, double overdraft) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.overdraft = overdraft;
    }

    public Account(AccountType type, double amount, double overdraft) {
        this.type = type;
        this.amount = amount;
        this.overdraft = overdraft;
    }
}
