package com.thesett.accounts.test.basicTransaction;

import java.lang.reflect.Proxy;

import com.thesett.test.base.WebServiceIsolationCRUDTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.proxies.DefaultProxy;

import com.thesett.accounts.dao.BasicTransactionDAO;
import com.thesett.accounts.model.BasicTransaction;
import com.thesett.accounts.services.rest.BasicTransactionResource;

public class BasicTransactionServiceWebServiceIsolationCRUDTest extends WebServiceIsolationCRUDTestBase<BasicTransaction, Long>
{
    public BasicTransactionServiceWebServiceIsolationCRUDTest()
    {
        super(new BasicTransactionTestData());
    }

    protected CRUD<BasicTransaction, Long> getServiceLayer(CRUD<BasicTransaction, Long> dao)
    {
        BasicTransactionDAO basicTransactionDAO =
            (BasicTransactionDAO) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[] { BasicTransactionDAO.class },
                new DefaultProxy(dao));

        return new BasicTransactionResource(basicTransactionDAO);
    }
}
