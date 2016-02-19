package com.thesett.accounts.test.taxEntry;

import com.thesett.test.base.JsonSerDesCRUDTestBase;

import com.thesett.accounts.model.TaxEntry;    

public class TaxEntryJsonSerDesCRUDTest extends JsonSerDesCRUDTestBase<TaxEntry, Long>
{
    public TaxEntryJsonSerDesCRUDTest()
    {
        super(new TaxEntryTestData());
    }
}
