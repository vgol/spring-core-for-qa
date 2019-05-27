package com.acme.banking.dbo.ooad.domain;

import com.acme.banking.dbo.ooad.dal.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:test-spring-context.xml", "classpath:spring-context.xml"})
public class SavingAccountTest {

    @MockBean
    AccountRepository accountRepository;

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
