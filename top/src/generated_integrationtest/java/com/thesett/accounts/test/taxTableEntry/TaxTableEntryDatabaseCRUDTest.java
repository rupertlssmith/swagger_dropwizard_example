package com.thesett.accounts.test.taxTableEntry;

import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.accounts.top.Main;
import com.thesett.test.base.DatabaseCRUDTestBase;
import com.thesett.util.dao.HibernateTransactionalProxy;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.TaxTableEntryDAO;
import com.thesett.accounts.dao.TaxTableEntryDAOImpl;
import com.thesett.accounts.model.TaxTableEntry;

public class TaxTableEntryDatabaseCRUDTest extends DatabaseCRUDTestBase<TaxTableEntry, Long>
{
    public TaxTableEntryDatabaseCRUDTest()
    {
        super(new TaxTableEntryTestData(), TaxTableEntry.class, new AppTestSetupController(), Main.class,
            ResourceUtils.resourceFilePath("config.yml"));
    }

    /** {@inheritDoc} */
    protected CRUD<TaxTableEntry, Long> getDao()
    {
        return new TaxTableEntryDAOImpl(sessionFactory, validatorFactory);
    }

    /** {@inheritDoc} */
    protected TaxTableEntryDAO getTransactionalDAO()
    {
        TaxTableEntryDAO taxTableEntryDAO = new TaxTableEntryDAOImpl(sessionFactory, validatorFactory);

        return HibernateTransactionalProxy.proxy(taxTableEntryDAO, TaxTableEntryDAO.class, sessionFactory);
    }
}
