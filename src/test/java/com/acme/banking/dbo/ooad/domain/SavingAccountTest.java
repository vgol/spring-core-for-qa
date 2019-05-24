package com.acme.banking.dbo.ooad.domain;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class SavingAccountTest {

    @Test
    public void depositShouldChangeAmount() {
        SavingAccount account = new SavingAccount(1L, 0.0);

        account.deposit(1.0);

        assertThat(account.getAmount()).isEqualTo(1.0);
    }

    @Test(expected = IllegalStateException.class)
    public void notValidWithdrawShouldThrowException() {
        SavingAccount account = new SavingAccount(1L, 0.0) {
            boolean validate(double amount) {
                return true;
            }
        };

        account.withdraw(0.5);
    }

    @Test
    public void validWithdrowShouldWithdraw() {
        SavingAccount account = new SavingAccount(1L, 2.0) {
            boolean validate(double amount) {
                return false;
            }
        };

        account.withdraw(1.0);

        assertThat(account.getAmount()).isEqualTo(1.0);
    }

    @Test
    public void validateInvalidWithdrawal() {
        SavingAccount account = new SavingAccount(1L, 5.0);

        boolean validationResult = account.validate(5.1);

        assertThat(validationResult).isEqualTo(true);
    }

    @Test
    public void validateValidWithdrawal() {
        SavingAccount account = new SavingAccount(1L, 4.0);

        boolean validationResult = account.validate(5.0);

        assertThat(validationResult).isEqualTo(false);
    }
}
