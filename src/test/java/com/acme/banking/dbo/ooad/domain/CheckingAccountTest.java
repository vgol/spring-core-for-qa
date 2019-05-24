package com.acme.banking.dbo.ooad.domain;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class CheckingAccountTest {

    @Test
    public void withdrawalLessThanCurrentAmount() {
        CheckingAccount sut = new CheckingAccount(1L, 5.0, 4.0);

        sut.withdraw(2.0);

        assertThat(sut.getAmount()).isEqualTo(3.0);
    }

    @Test
    public void withdrawalLessThanCurrentAmountPlusOverdraft() {
        CheckingAccount sut = new CheckingAccount(1L, 5.0, 4.0);

        sut.withdraw(6.0);

        assertThat(sut.getAmount()).isEqualTo(-1.0);
    }

    @Test(expected = IllegalStateException.class)
    public void withdrawalGreaterThanCurrentAmountPlusOverdraft() {
        CheckingAccount sut = new CheckingAccount(1L, 5.0, 4.0);

        sut.withdraw(10.0);
    }
}
