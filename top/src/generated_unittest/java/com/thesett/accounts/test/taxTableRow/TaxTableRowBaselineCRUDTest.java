package com.thesett.accounts.test.taxTableRow;

import com.thesett.test.base.BaselineCRUDTestBase;

import com.thesett.accounts.model.TaxTableRow;    

public class TaxTableRowBaselineCRUDTest extends BaselineCRUDTestBase<TaxTableRow, Long>
{
    public TaxTableRowBaselineCRUDTest()
    {
        super(new TaxTableRowTestData());
    }
}
