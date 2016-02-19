package com.thesett.accounts.test.taxTableEntry;

import java.lang.reflect.Proxy;
import java.util.Collection;

import org.junit.runners.Parameterized;
import com.thesett.test.base.WebServiceIsolationValidationTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.proxies.DefaultProxy;

import com.thesett.accounts.dao.TaxTableEntryDAO;
import com.thesett.accounts.model.TaxTableEntry;
import com.thesett.accounts.services.rest.TaxTableEntryResource;

public class TaxTableEntryServiceWebServiceIsolationValidationTest
    extends WebServiceIsolationValidationTestBase<TaxTableEntry, Long>
{
    public TaxTableEntryServiceWebServiceIsolationValidationTest(TaxTableEntry example, boolean valid)
    {
        super(new TaxTableEntryTestData(), example, valid);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        return buildExamples(new TaxTableEntryTestData());
    }

    protected CRUD<TaxTableEntry, Long> getServiceLayer(CRUD<TaxTableEntry, Long> dao)
    {
        TaxTableEntryDAO taxTableEntryDAO =
            (TaxTableEntryDAO) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[] { TaxTableEntryDAO.class },
                new DefaultProxy(dao));

        return new TaxTableEntryResource(taxTableEntryDAO);
    }
}
