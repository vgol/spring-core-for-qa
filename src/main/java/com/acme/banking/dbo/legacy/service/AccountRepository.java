package com.acme.banking.dbo.legacy.service;

import com.acme.banking.dbo.legacy.domain.Account;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/** TODO Rename according intention and extract interface */
public class AccountRepository {
    private static Map<Long, Account> accounts = new HashMap<>();

    public static Account findById(long id) {
        return accounts.get(id);
    }

    public static void save(Account account) {
        Long maxId = accounts.keySet().stream()
                .max(Comparator.naturalOrder())
                .orElse(0L);

        long newId = maxId + 1;
        accounts.put(newId, new Account(newId, account.type, account.amount, account.overdraft));
    }

    public static void reset() {
        accounts.clear();
    }
}
