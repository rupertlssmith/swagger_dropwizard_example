package com.thesett.accounts.test.entry;

import java.lang.reflect.Proxy;
import java.util.Collection;

import org.junit.runners.Parameterized;
import com.thesett.test.base.WebServiceIsolationValidationTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.proxies.DefaultProxy;

import com.thesett.accounts.dao.EntryDAO;
import com.thesett.accounts.model.Entry;
import com.thesett.accounts.services.rest.EntryResource;

public class EntryServiceWebServiceIsolationValidationTest
    extends WebServiceIsolationValidationTestBase<Entry, Long>
{
    public EntryServiceWebServiceIsolationValidationTest(Entry example, boolean valid)
    {
        super(new EntryTestData(), example, valid);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        return buildExamples(new EntryTestData());
    }

    protected CRUD<Entry, Long> getServiceLayer(CRUD<Entry, Long> dao)
    {
        EntryDAO entryDAO =
            (EntryDAO) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[] { EntryDAO.class },
                new DefaultProxy(dao));

        return new EntryResource(entryDAO);
    }
}
