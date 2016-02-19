package com.thesett.accounts.test.taxEntry;

import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.accounts.top.Main;
import com.thesett.test.base.DatabaseCRUDTestBase;
import com.thesett.util.dao.HibernateTransactionalProxy;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.TaxEntryDAO;
import com.thesett.accounts.dao.TaxEntryDAOImpl;
import com.thesett.accounts.model.TaxEntry;

public class TaxEntryDatabaseCRUDTest extends DatabaseCRUDTestBase<TaxEntry, Long>
{
    public TaxEntryDatabaseCRUDTest()
    {
        super(new TaxEntryTestData(), TaxEntry.class, new AppTestSetupController(), Main.class,
            ResourceUtils.resourceFilePath("config.yml"));
    }

    /** {@inheritDoc} */
    protected CRUD<TaxEntry, Long> getDao()
    {
        return new TaxEntryDAOImpl(sessionFactory, validatorFactory);
    }

    /** {@inheritDoc} */
    protected TaxEntryDAO getTransactionalDAO()
    {
        TaxEntryDAO taxEntryDAO = new TaxEntryDAOImpl(sessionFactory, validatorFactory);

        return HibernateTransactionalProxy.proxy(taxEntryDAO, TaxEntryDAO.class, sessionFactory);
    }
}
