package com.thesett.accounts.test.taxEntry;

import com.thesett.test.base.BaselineCRUDTestBase;

import com.thesett.accounts.model.TaxEntry;    

public class TaxEntryBaselineCRUDTest extends BaselineCRUDTestBase<TaxEntry, Long>
{
    public TaxEntryBaselineCRUDTest()
    {
        super(new TaxEntryTestData());
    }
}
