package com.acme.banking.dbo.spring.service;

import com.acme.banking.dbo.spring.dao.AccountRepository;
import com.acme.banking.dbo.spring.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferService {
    @Autowired private AccountRepository accounts;

    @Transactional
    public void transfer(long fromId, long toId, double amount) {
        Account from = accounts.findById(fromId).orElseThrow(() -> new IllegalStateException("Account not found"));
        Account to = accounts.findById(toId).orElseThrow(() -> new IllegalStateException("Account not found"));

        from.setAmount(from.getAmount() - amount);
        to.setAmount(to.getAmount() + amount);

        accounts.save(from);
        accounts.save(to);
    }
}
