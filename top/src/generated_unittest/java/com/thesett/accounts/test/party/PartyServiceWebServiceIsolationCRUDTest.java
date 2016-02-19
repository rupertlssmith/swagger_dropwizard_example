package com.thesett.accounts.test.party;

import java.lang.reflect.Proxy;

import com.thesett.test.base.WebServiceIsolationCRUDTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.proxies.DefaultProxy;

import com.thesett.accounts.dao.PartyDAO;
import com.thesett.accounts.model.Party;
import com.thesett.accounts.services.rest.PartyResource;

public class PartyServiceWebServiceIsolationCRUDTest extends WebServiceIsolationCRUDTestBase<Party, Long>
{
    public PartyServiceWebServiceIsolationCRUDTest()
    {
        super(new PartyTestData());
    }

    protected CRUD<Party, Long> getServiceLayer(CRUD<Party, Long> dao)
    {
        PartyDAO partyDAO =
            (PartyDAO) Proxy.newProxyInstance(dao.getClass().getClassLoader(), new Class[] { PartyDAO.class },
                new DefaultProxy(dao));

        return new PartyResource(partyDAO);
    }
}
