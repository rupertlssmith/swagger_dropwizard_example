package com.thesett.accounts.test.taxTable;

import com.thesett.test.base.JsonSerDesCRUDTestBase;

import com.thesett.accounts.model.TaxTable;    

public class TaxTableJsonSerDesCRUDTest extends JsonSerDesCRUDTestBase<TaxTable, Long>
{
    public TaxTableJsonSerDesCRUDTest()
    {
        super(new TaxTableTestData());
    }
}
