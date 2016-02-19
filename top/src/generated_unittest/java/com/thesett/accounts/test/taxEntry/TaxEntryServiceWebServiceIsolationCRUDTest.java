package com.thesett.accounts.test.taxEntry;

import java.lang.reflect.Proxy;

import com.thesett.test.base.WebServiceIsolationCRUDTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.proxies.DefaultProxy;

import com.thesett.accounts.dao.TaxEntryDAO;
import com.thesett.accounts.model.TaxEntry;
import com.thesett.accounts.services.rest.TaxEntryResource;

public class TaxEntryServiceWebServiceIsolationCRUDTest extends WebServiceIsolationCRUDTestBase<TaxEntry, Long>
{
    public TaxEntryServiceWebServiceIsolationCRUDTest()
    {
        super(new TaxEntryTestData());
    }

    protected CRUD<TaxEntry, Long> getServiceLayer(CRUD<TaxEntry, Long> dao)
    {
        TaxEntryDAO taxEntryDAO =
            (TaxEntryDAO) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[] { TaxEntryDAO.class },
                new DefaultProxy(dao));

        return new TaxEntryResource(taxEntryDAO);
    }
}
