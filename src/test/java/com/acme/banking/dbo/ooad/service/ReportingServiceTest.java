package com.acme.banking.dbo.ooad.service;

import com.acme.banking.dbo.ooad.dal.AccountRepository;
import com.acme.banking.dbo.ooad.domain.Account;
import com.acme.banking.dbo.ooad.service.ReportingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class ReportingServiceTest {
    @MockBean AccountRepository stubAccountRepository;
    @Autowired ReportingService sut;

    @Test(expected = EntityNotFoundException.class)
    public void shouldGetExceptionWhenNoAccountFound() {
//        AccountRepository stubAccountRepository = mock(AccountRepository.class);
        when(stubAccountRepository.findById(anyLong()))
                .thenThrow(new EntityNotFoundException());

        sut.reportForAccount(0L);
    }

    @Test
    public void shouldGetReportForAccountWhenAccountExists() {
        //region Given
        Account stubAccount = mock(Account.class);
        when(stubAccount.getAmount()).thenReturn(100.0);
        when(stubAccount.getId()).thenReturn(0L);
//        AccountRepository stubRepo = mock(AccountRepository.class);
        when(stubAccountRepository.findById(0L)).thenReturn(stubAccount);
//        ReportingService sut = new ReportingService(stubAccountRepository);
        //endregion

        //region When
        String actualReport = sut.reportForAccount(0L);
        //endregion

        //region Then
        assertThat(actualReport)
                .contains("## " + String.valueOf(0L))
                .contains("100.0");
        //endregion
    }
}
