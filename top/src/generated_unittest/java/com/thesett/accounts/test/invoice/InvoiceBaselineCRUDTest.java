package com.thesett.accounts.test.invoice;

import com.thesett.test.base.BaselineCRUDTestBase;

import com.thesett.accounts.model.Invoice;    

public class InvoiceBaselineCRUDTest extends BaselineCRUDTestBase<Invoice, Long>
{
    public InvoiceBaselineCRUDTest()
    {
        super(new InvoiceTestData());
    }
}
