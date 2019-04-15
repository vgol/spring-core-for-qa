package com.acme.banking.dbo.legacy.domain;

import org.junit.Ignore;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class AccountTest {
    @Test @Ignore
    public void externalCodeShouldConcernStateConsistency() {
        Account accountStructure = new Account();
        accountStructure.overdraft = 1_000;
        accountStructure.amount = 0;

        //Look ma, no checks!
        accountStructure.amount -= 2_000;

        assertThat(accountStructure.amount)
            .describedAs("Inconsistent state when lack of behavior encapsulation within CheckingAccount")
            .isGreaterThan(-1_000);
    }
}
