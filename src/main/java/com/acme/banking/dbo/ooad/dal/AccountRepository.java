package com.acme.banking.dbo.ooad.dal;

import com.acme.banking.dbo.ooad.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository {
    Account findById(long id);
}
