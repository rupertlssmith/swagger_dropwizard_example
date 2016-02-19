package com.thesett.accounts.test.taxTableRow;

import java.lang.reflect.Proxy;
import java.util.Collection;

import org.junit.runners.Parameterized;
import com.thesett.test.base.WebServiceIsolationValidationTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.proxies.DefaultProxy;

import com.thesett.accounts.dao.TaxTableRowDAO;
import com.thesett.accounts.model.TaxTableRow;
import com.thesett.accounts.services.rest.TaxTableRowResource;

public class TaxTableRowServiceWebServiceIsolationValidationTest
    extends WebServiceIsolationValidationTestBase<TaxTableRow, Long>
{
    public TaxTableRowServiceWebServiceIsolationValidationTest(TaxTableRow example, boolean valid)
    {
        super(new TaxTableRowTestData(), example, valid);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        return buildExamples(new TaxTableRowTestData());
    }

    protected CRUD<TaxTableRow, Long> getServiceLayer(CRUD<TaxTableRow, Long> dao)
    {
        TaxTableRowDAO taxTableRowDAO =
            (TaxTableRowDAO) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[] { TaxTableRowDAO.class },
                new DefaultProxy(dao));

        return new TaxTableRowResource(taxTableRowDAO);
    }
}
