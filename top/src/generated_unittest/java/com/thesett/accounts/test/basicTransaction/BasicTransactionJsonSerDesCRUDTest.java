package com.thesett.accounts.test.basicTransaction;

import com.thesett.test.base.JsonSerDesCRUDTestBase;

import com.thesett.accounts.model.BasicTransaction;    

public class BasicTransactionJsonSerDesCRUDTest extends JsonSerDesCRUDTestBase<BasicTransaction, Long>
{
    public BasicTransactionJsonSerDesCRUDTest()
    {
        super(new BasicTransactionTestData());
    }
}
