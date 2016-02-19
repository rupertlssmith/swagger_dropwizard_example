package com.thesett.accounts.test.taxTableEntry;

import com.thesett.test.base.JsonSerDesCRUDTestBase;

import com.thesett.accounts.model.TaxTableEntry;    

public class TaxTableEntryJsonSerDesCRUDTest extends JsonSerDesCRUDTestBase<TaxTableEntry, Long>
{
    public TaxTableEntryJsonSerDesCRUDTest()
    {
        super(new TaxTableEntryTestData());
    }
}
