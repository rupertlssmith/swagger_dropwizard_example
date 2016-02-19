package com.thesett.accounts.test.taxTableRow;

import java.lang.reflect.Proxy;

import com.thesett.test.base.WebServiceIsolationCRUDTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.proxies.DefaultProxy;

import com.thesett.accounts.dao.TaxTableRowDAO;
import com.thesett.accounts.model.TaxTableRow;
import com.thesett.accounts.services.rest.TaxTableRowResource;

public class TaxTableRowServiceWebServiceIsolationCRUDTest extends WebServiceIsolationCRUDTestBase<TaxTableRow, Long>
{
    public TaxTableRowServiceWebServiceIsolationCRUDTest()
    {
        super(new TaxTableRowTestData());
    }

    protected CRUD<TaxTableRow, Long> getServiceLayer(CRUD<TaxTableRow, Long> dao)
    {
        TaxTableRowDAO taxTableRowDAO =
            (TaxTableRowDAO) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[] { TaxTableRowDAO.class },
                new DefaultProxy(dao));

        return new TaxTableRowResource(taxTableRowDAO);
    }
}
