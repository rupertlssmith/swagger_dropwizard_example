package com.thesett.accounts.test.taxEntry;

import java.lang.reflect.Proxy;
import java.util.Collection;

import org.junit.runners.Parameterized;
import com.thesett.test.base.WebServiceIsolationValidationTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.proxies.DefaultProxy;

import com.thesett.accounts.dao.TaxEntryDAO;
import com.thesett.accounts.model.TaxEntry;
import com.thesett.accounts.services.rest.TaxEntryResource;

public class TaxEntryServiceWebServiceIsolationValidationTest
    extends WebServiceIsolationValidationTestBase<TaxEntry, Long>
{
    public TaxEntryServiceWebServiceIsolationValidationTest(TaxEntry example, boolean valid)
    {
        super(new TaxEntryTestData(), example, valid);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        return buildExamples(new TaxEntryTestData());
    }

    protected CRUD<TaxEntry, Long> getServiceLayer(CRUD<TaxEntry, Long> dao)
    {
        TaxEntryDAO taxEntryDAO =
            (TaxEntryDAO) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[] { TaxEntryDAO.class },
                new DefaultProxy(dao));

        return new TaxEntryResource(taxEntryDAO);
    }
}
