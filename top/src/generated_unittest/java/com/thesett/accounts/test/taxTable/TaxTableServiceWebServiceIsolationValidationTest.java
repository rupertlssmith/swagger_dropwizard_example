package com.thesett.accounts.test.taxTable;

import java.lang.reflect.Proxy;
import java.util.Collection;

import org.junit.runners.Parameterized;
import com.thesett.test.base.WebServiceIsolationValidationTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.proxies.DefaultProxy;

import com.thesett.accounts.dao.TaxTableDAO;
import com.thesett.accounts.model.TaxTable;
import com.thesett.accounts.services.rest.TaxTableResource;

public class TaxTableServiceWebServiceIsolationValidationTest
    extends WebServiceIsolationValidationTestBase<TaxTable, Long>
{
    public TaxTableServiceWebServiceIsolationValidationTest(TaxTable example, boolean valid)
    {
        super(new TaxTableTestData(), example, valid);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        return buildExamples(new TaxTableTestData());
    }

    protected CRUD<TaxTable, Long> getServiceLayer(CRUD<TaxTable, Long> dao)
    {
        TaxTableDAO taxTableDAO =
            (TaxTableDAO) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[] { TaxTableDAO.class },
                new DefaultProxy(dao));

        return new TaxTableResource(taxTableDAO);
    }
}
