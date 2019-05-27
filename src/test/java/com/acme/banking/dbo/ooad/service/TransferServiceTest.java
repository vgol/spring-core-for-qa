package com.acme.banking.dbo.ooad.service;

import com.acme.banking.dbo.ooad.dal.AccountRepository;
import com.acme.banking.dbo.ooad.domain.Account;
import com.acme.banking.dbo.ooad.domain.SavingAccount;
import com.acme.banking.dbo.ooad.service.TransferService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class TransferServiceTest {
    @MockBean
    AccountRepository stubAccountRepository;
    @Autowired
    TransferService sut;

    @Test
    public void shouldUpdateAccountsStateWhenTransfer() {
        //region Given
        Account fromAccount = mock(Account.class);
        Account toAccount = mock(Account.class);
        //endregion

        //region When
        sut.transfer(fromAccount, toAccount, 100.);
        //endregion

        //region Then
        verify(fromAccount, times(1)).withdraw(100.);
        verify(toAccount).deposit(anyDouble());
        //endregion
    }
}
