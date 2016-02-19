package com.thesett.accounts.test.entry;

import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.accounts.top.Main;
import com.thesett.test.base.DatabaseCRUDTestBase;
import com.thesett.util.dao.HibernateTransactionalProxy;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.EntryDAO;
import com.thesett.accounts.dao.EntryDAOImpl;
import com.thesett.accounts.model.Entry;

public class EntryDatabaseCRUDTest extends DatabaseCRUDTestBase<Entry, Long>
{
    public EntryDatabaseCRUDTest()
    {
        super(new EntryTestData(), Entry.class, new AppTestSetupController(), Main.class,
            ResourceUtils.resourceFilePath("config.yml"));
    }

    /** {@inheritDoc} */
    protected CRUD<Entry, Long> getDao()
    {
        return new EntryDAOImpl(sessionFactory, validatorFactory);
    }

    /** {@inheritDoc} */
    protected EntryDAO getTransactionalDAO()
    {
        EntryDAO entryDAO = new EntryDAOImpl(sessionFactory, validatorFactory);

        return HibernateTransactionalProxy.proxy(entryDAO, EntryDAO.class, sessionFactory);
    }
}
