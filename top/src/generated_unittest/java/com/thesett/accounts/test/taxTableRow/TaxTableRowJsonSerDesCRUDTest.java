package com.thesett.accounts.test.taxTableRow;

import com.thesett.test.base.JsonSerDesCRUDTestBase;

import com.thesett.accounts.model.TaxTableRow;    

public class TaxTableRowJsonSerDesCRUDTest extends JsonSerDesCRUDTestBase<TaxTableRow, Long>
{
    public TaxTableRowJsonSerDesCRUDTest()
    {
        super(new TaxTableRowTestData());
    }
}
