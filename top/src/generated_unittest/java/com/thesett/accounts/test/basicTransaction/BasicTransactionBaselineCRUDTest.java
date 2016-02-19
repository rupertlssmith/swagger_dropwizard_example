package com.thesett.accounts.test.basicTransaction;

import com.thesett.test.base.BaselineCRUDTestBase;

import com.thesett.accounts.model.BasicTransaction;    

public class BasicTransactionBaselineCRUDTest extends BaselineCRUDTestBase<BasicTransaction, Long>
{
    public BasicTransactionBaselineCRUDTest()
    {
        super(new BasicTransactionTestData());
    }
}
