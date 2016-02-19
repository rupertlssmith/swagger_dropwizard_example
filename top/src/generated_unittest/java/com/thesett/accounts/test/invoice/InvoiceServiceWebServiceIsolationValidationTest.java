package com.thesett.accounts.test.invoice;

import java.lang.reflect.Proxy;
import java.util.Collection;

import org.junit.runners.Parameterized;
import com.thesett.test.base.WebServiceIsolationValidationTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.proxies.DefaultProxy;

import com.thesett.accounts.dao.InvoiceDAO;
import com.thesett.accounts.model.Invoice;
import com.thesett.accounts.services.rest.InvoiceResource;

public class InvoiceServiceWebServiceIsolationValidationTest
    extends WebServiceIsolationValidationTestBase<Invoice, Long>
{
    public InvoiceServiceWebServiceIsolationValidationTest(Invoice example, boolean valid)
    {
        super(new InvoiceTestData(), example, valid);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        return buildExamples(new InvoiceTestData());
    }

    protected CRUD<Invoice, Long> getServiceLayer(CRUD<Invoice, Long> dao)
    {
        InvoiceDAO invoiceDAO =
            (InvoiceDAO) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[] { InvoiceDAO.class },
                new DefaultProxy(dao));

        return new InvoiceResource(invoiceDAO);
    }
}
