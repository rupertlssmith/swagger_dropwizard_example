package com.thesett.accounts.test.entry;

import java.lang.reflect.Proxy;

import com.thesett.test.base.WebServiceIsolationCRUDTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.proxies.DefaultProxy;

import com.thesett.accounts.dao.EntryDAO;
import com.thesett.accounts.model.Entry;
import com.thesett.accounts.services.rest.EntryResource;

public class EntryServiceWebServiceIsolationCRUDTest extends WebServiceIsolationCRUDTestBase<Entry, Long>
{
    public EntryServiceWebServiceIsolationCRUDTest()
    {
        super(new EntryTestData());
    }

    protected CRUD<Entry, Long> getServiceLayer(CRUD<Entry, Long> dao)
    {
        EntryDAO entryDAO =
            (EntryDAO) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[] { EntryDAO.class },
                new DefaultProxy(dao));

        return new EntryResource(entryDAO);
    }
}
