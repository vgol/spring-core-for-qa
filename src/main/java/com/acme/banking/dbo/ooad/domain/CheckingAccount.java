package com.acme.banking.dbo.ooad.domain;

public class CheckingAccount extends SavingAccount {
    private double overdraft;

    public CheckingAccount(long id, double amount, double overdraft) {
        super(id, amount);
        this.overdraft = overdraft;
    }

    @Override
    protected boolean isNotEnoughFunds(double amount) {
        return super.isNotEnoughFunds(amount - overdraft);
    }
}

/** Spring Template Method Example */
/*
abstract class JdbcTemplate {
    public void executeQuery() {
        try(
                Connection c = ???;
                Staement s = c.getSt();
                Query q = s.creQ();
        ) {

            //......
            doQuery();
            //......

            s.getWarnings()
            while(e.getNextException() != null) {
                e = e.getNextException();
            }
            c.getWarnings();
            while(e.getNextException() != null) {
                e = e.getNextException();
            }

        } catch (SQLException e) {
            while(e.getNextException() != null) {
                e = e.getNextException();
            }
        }
    }

    protected abstract void doQuery();
}
*/