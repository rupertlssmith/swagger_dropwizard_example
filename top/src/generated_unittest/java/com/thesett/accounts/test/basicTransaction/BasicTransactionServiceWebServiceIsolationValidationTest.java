package com.thesett.accounts.test.basicTransaction;

import java.lang.reflect.Proxy;
import java.util.Collection;

import org.junit.runners.Parameterized;
import com.thesett.test.base.WebServiceIsolationValidationTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.proxies.DefaultProxy;

import com.thesett.accounts.dao.BasicTransactionDAO;
import com.thesett.accounts.model.BasicTransaction;
import com.thesett.accounts.services.rest.BasicTransactionResource;

public class BasicTransactionServiceWebServiceIsolationValidationTest
    extends WebServiceIsolationValidationTestBase<BasicTransaction, Long>
{
    public BasicTransactionServiceWebServiceIsolationValidationTest(BasicTransaction example, boolean valid)
    {
        super(new BasicTransactionTestData(), example, valid);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        return buildExamples(new BasicTransactionTestData());
    }

    protected CRUD<BasicTransaction, Long> getServiceLayer(CRUD<BasicTransaction, Long> dao)
    {
        BasicTransactionDAO basicTransactionDAO =
            (BasicTransactionDAO) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[] { BasicTransactionDAO.class },
                new DefaultProxy(dao));

        return new BasicTransactionResource(basicTransactionDAO);
    }
}
