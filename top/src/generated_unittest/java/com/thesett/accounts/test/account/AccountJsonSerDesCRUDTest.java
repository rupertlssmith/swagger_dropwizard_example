package com.thesett.accounts.test.account;

import com.thesett.test.base.JsonSerDesCRUDTestBase;

import com.thesett.accounts.model.Account;    

public class AccountJsonSerDesCRUDTest extends JsonSerDesCRUDTestBase<Account, Long>
{
    public AccountJsonSerDesCRUDTest()
    {
        super(new AccountTestData());
    }
}
