package com.thesett.accounts.test.invoice;

import com.thesett.test.base.JsonSerDesCRUDTestBase;

import com.thesett.accounts.model.Invoice;    

public class InvoiceJsonSerDesCRUDTest extends JsonSerDesCRUDTestBase<Invoice, Long>
{
    public InvoiceJsonSerDesCRUDTest()
    {
        super(new InvoiceTestData());
    }
}
