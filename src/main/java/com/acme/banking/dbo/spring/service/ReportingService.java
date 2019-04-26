package com.acme.banking.dbo.spring.service;

import com.acme.banking.dbo.spring.dao.AccountRepository;
import com.acme.banking.dbo.spring.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope("singleton")
@Lazy
@PropertySource("classpath:application.properties")
public class ReportingService {
    @Value("${marker}") private String layoutMarker;
    @Autowired private AccountRepository accounts;

    public void setLayoutMarker(String layoutMarker) {
        this.layoutMarker = layoutMarker;
    }

    @PostConstruct
    public void onCreate() {
        System.out.println("ReportingService created");
    }

    @PreDestroy
    public void onShutDown() {
        System.out.println("ReportingService shut down");
    }

    public String accountReport(long id) {
        Account account = accounts.findById(id).orElseThrow(() -> new IllegalStateException("Account not found"));
        return layoutMarker + layoutMarker + " " + account.toString();
    }
}
