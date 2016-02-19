package com.thesett.accounts.test.taxTable;

import com.thesett.test.base.BaselineCRUDTestBase;

import com.thesett.accounts.model.TaxTable;    

public class TaxTableBaselineCRUDTest extends BaselineCRUDTestBase<TaxTable, Long>
{
    public TaxTableBaselineCRUDTest()
    {
        super(new TaxTableTestData());
    }
}
