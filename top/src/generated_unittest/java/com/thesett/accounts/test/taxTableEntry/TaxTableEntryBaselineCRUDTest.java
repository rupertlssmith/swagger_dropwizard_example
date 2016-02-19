package com.thesett.accounts.test.taxTableEntry;

import com.thesett.test.base.BaselineCRUDTestBase;

import com.thesett.accounts.model.TaxTableEntry;    

public class TaxTableEntryBaselineCRUDTest extends BaselineCRUDTestBase<TaxTableEntry, Long>
{
    public TaxTableEntryBaselineCRUDTest()
    {
        super(new TaxTableEntryTestData());
    }
}
