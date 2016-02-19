package com.thesett.accounts.test.invoice;

import java.lang.reflect.Proxy;

import com.thesett.test.base.WebServiceIsolationCRUDTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.proxies.DefaultProxy;

import com.thesett.accounts.dao.InvoiceDAO;
import com.thesett.accounts.model.Invoice;
import com.thesett.accounts.services.rest.InvoiceResource;

public class InvoiceServiceWebServiceIsolationCRUDTest extends WebServiceIsolationCRUDTestBase<Invoice, Long>
{
    public InvoiceServiceWebServiceIsolationCRUDTest()
    {
        super(new InvoiceTestData());
    }

    protected CRUD<Invoice, Long> getServiceLayer(CRUD<Invoice, Long> dao)
    {
        InvoiceDAO invoiceDAO =
            (InvoiceDAO) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[] { InvoiceDAO.class },
                new DefaultProxy(dao));

        return new InvoiceResource(invoiceDAO);
    }
}
