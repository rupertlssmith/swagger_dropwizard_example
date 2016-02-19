package com.thesett.accounts.test.party;

import java.lang.reflect.Proxy;
import java.util.Collection;

import org.junit.runners.Parameterized;
import com.thesett.test.base.WebServiceIsolationValidationTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.proxies.DefaultProxy;

import com.thesett.accounts.dao.PartyDAO;
import com.thesett.accounts.model.Party;
import com.thesett.accounts.services.rest.PartyResource;

public class PartyServiceWebServiceIsolationValidationTest
    extends WebServiceIsolationValidationTestBase<Party, Long>
{
    public PartyServiceWebServiceIsolationValidationTest(Party example, boolean valid)
    {
        super(new PartyTestData(), example, valid);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        return buildExamples(new PartyTestData());
    }

    protected CRUD<Party, Long> getServiceLayer(CRUD<Party, Long> dao)
    {
        PartyDAO partyDAO =
            (PartyDAO) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[] { PartyDAO.class },
                new DefaultProxy(dao));

        return new PartyResource(partyDAO);
    }
}
