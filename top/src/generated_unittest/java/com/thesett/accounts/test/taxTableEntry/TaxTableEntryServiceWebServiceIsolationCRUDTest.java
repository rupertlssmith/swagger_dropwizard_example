package com.thesett.accounts.test.taxTableEntry;

import java.lang.reflect.Proxy;

import com.thesett.test.base.WebServiceIsolationCRUDTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.proxies.DefaultProxy;

import com.thesett.accounts.dao.TaxTableEntryDAO;
import com.thesett.accounts.model.TaxTableEntry;
import com.thesett.accounts.services.rest.TaxTableEntryResource;

public class TaxTableEntryServiceWebServiceIsolationCRUDTest extends WebServiceIsolationCRUDTestBase<TaxTableEntry, Long>
{
    public TaxTableEntryServiceWebServiceIsolationCRUDTest()
    {
        super(new TaxTableEntryTestData());
    }

    protected CRUD<TaxTableEntry, Long> getServiceLayer(CRUD<TaxTableEntry, Long> dao)
    {
        TaxTableEntryDAO taxTableEntryDAO =
            (TaxTableEntryDAO) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[] { TaxTableEntryDAO.class },
                new DefaultProxy(dao));

        return new TaxTableEntryResource(taxTableEntryDAO);
    }
}
