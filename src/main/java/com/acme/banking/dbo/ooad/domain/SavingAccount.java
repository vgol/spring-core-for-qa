package com.acme.banking.dbo.ooad.domain;

public class SavingAccount implements Account {
    private long id;
    private double amount;

    public SavingAccount(long id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /** Template Method */
    @Override
    public void withdraw(double amount) {
        //Guard Clauses:
        if (isNotEnoughFunds(amount)) throw new IllegalStateException();

        this.setAmount(this.getAmount() - amount);
    }

    /** Step */
    protected boolean isNotEnoughFunds(double amount) {
        return amount > this.getAmount();
    }
}
