package com.acme.banking.dbo.legacy.service;

import com.acme.banking.dbo.legacy.domain.Account;
import com.acme.banking.dbo.legacy.domain.AccountType;

/** TODO Rename according intention, extract interface and move out behavior for polymorhpic algorithm */
public class ReportingService {
    public static String reportForAccount(long id) {
        Account account = AccountRepository.findById(id);
        String commonReportString = "## " + account.id + " " + account.amount;

        if (account.type == AccountType.SAVING) {
            return commonReportString + " S";
        } else {
            return commonReportString + " C " + account.amount;
        }
    }
}
