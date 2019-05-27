package com.acme.banking.dbo.ooad.domain;

import com.acme.banking.dbo.ooad.dal.AccountRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:test-spring-context.xml", "classpath:spring-context.xml"})
@PropertySource("classpath:application.properties")
public class CheckingAccountTest {

    @MockBean
    AccountRepository accountRepository;

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
