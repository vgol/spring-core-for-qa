package com.acme.banking.dbo.ooad.domain;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class SavingAccountTest {

    @Test
    public void depositShouldChangeAmount() {
        SavingAccount sut = new SavingAccount(1L, 0.0);

        sut.deposit(1.0);

        assertThat(sut.getAmount()).isEqualTo(1.0);
    }

    @Test(expected = IllegalStateException.class)
    public void notValidWithdrawShouldThrowException() {
        SavingAccount sut = new SavingAccount(1L, 0.0);

        sut.withdraw(0.5);
    }

    @Test
    public void validWithdrowShouldWithdraw() {
        SavingAccount sut = new SavingAccount(1L, 2.0);

        sut.withdraw(1.0);

        assertThat(sut.getAmount()).isEqualTo(1.0);
    }
}
