package com.thesett.accounts.test.party;

import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.accounts.top.Main;
import com.thesett.test.base.DatabaseCRUDTestBase;
import com.thesett.util.dao.HibernateTransactionalProxy;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.PartyDAO;
import com.thesett.accounts.dao.PartyDAOImpl;
import com.thesett.accounts.model.Party;

public class PartyDatabaseCRUDTest extends DatabaseCRUDTestBase<Party, Long>
{
    public PartyDatabaseCRUDTest()
    {
        super(new PartyTestData(), Party.class, new AppTestSetupController(), Main.class,
            ResourceUtils.resourceFilePath("config.yml"));
    }

    /** {@inheritDoc} */
    protected CRUD<Party, Long> getDao()
    {
        return new PartyDAOImpl(sessionFactory, validatorFactory);
    }

    /** {@inheritDoc} */
    protected PartyDAO getTransactionalDAO()
    {
        PartyDAO partyDAO = new PartyDAOImpl(sessionFactory, validatorFactory);

        return HibernateTransactionalProxy.proxy(partyDAO, PartyDAO.class, sessionFactory);
    }
}
