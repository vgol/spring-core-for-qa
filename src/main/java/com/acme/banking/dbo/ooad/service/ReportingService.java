package com.acme.banking.dbo.ooad.service;

import com.acme.banking.dbo.ooad.dal.AccountRepository;
import com.acme.banking.dbo.ooad.domain.Account;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
public class ReportingService {
    //Creator [GRASP]
    //Factory Method [GoF]
    //Abstract Factory [GoF]
    //Registry [PoEAA]
    //Field DI
   @Value("${marker}") private String layoutMarker;
   @Autowired  private AccountRepository accounts;
   @Autowired  Logger logger;


    //Constructor DI
//    public ReportingService() {}
//
//    public ReportingService(AccountRepository accounts) {
//        this.accounts = accounts;
//    }

    public String reportForAccount(long id) {
        Account account = accounts.findById(id);
        return layoutMarker + layoutMarker + ' ' + account.getId() + " : " + account.getAmount();
    }
}
