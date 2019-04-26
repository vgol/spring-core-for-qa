package com.acme.banking.dbo.legacy.service;

import com.acme.banking.dbo.legacy.domain.Account;
import com.acme.banking.dbo.legacy.domain.AccountType;

public class TransferService {
    private static void withdraw(Account from, double amount) {
        if (from.type == AccountType.SAVING) {
            if (amount > from.amount) throw new IllegalStateException("Not enough funds to withdraw");
        } else if (from.type == AccountType.CHECKING) {
            if (amount > from.amount + from.overdraft) throw new IllegalStateException("Not enough funds to withdraw");
        }

        from.amount -= amount;
    }

    private static void deposit(Account to, double amount) {
        to.amount += amount;
    }

    public static void transfer(Account from, Account to, double amount) {
        withdraw(from, amount);
        deposit(to, amount);
    }
}
