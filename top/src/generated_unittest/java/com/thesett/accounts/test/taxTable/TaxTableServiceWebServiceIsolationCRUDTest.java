package com.thesett.accounts.test.taxTable;

import java.lang.reflect.Proxy;

import com.thesett.test.base.WebServiceIsolationCRUDTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.proxies.DefaultProxy;

import com.thesett.accounts.dao.TaxTableDAO;
import com.thesett.accounts.model.TaxTable;
import com.thesett.accounts.services.rest.TaxTableResource;

public class TaxTableServiceWebServiceIsolationCRUDTest extends WebServiceIsolationCRUDTestBase<TaxTable, Long>
{
    public TaxTableServiceWebServiceIsolationCRUDTest()
    {
        super(new TaxTableTestData());
    }

    protected CRUD<TaxTable, Long> getServiceLayer(CRUD<TaxTable, Long> dao)
    {
        TaxTableDAO taxTableDAO =
            (TaxTableDAO) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[] { TaxTableDAO.class },
                new DefaultProxy(dao));

        return new TaxTableResource(taxTableDAO);
    }
}
