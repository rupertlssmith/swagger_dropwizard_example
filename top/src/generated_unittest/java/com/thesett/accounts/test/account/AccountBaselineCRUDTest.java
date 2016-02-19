package com.thesett.accounts.test.account;

import com.thesett.test.base.BaselineCRUDTestBase;

import com.thesett.accounts.model.Account;    

public class AccountBaselineCRUDTest extends BaselineCRUDTestBase<Account, Long>
{
    public AccountBaselineCRUDTest()
    {
        super(new AccountTestData());
    }
}
