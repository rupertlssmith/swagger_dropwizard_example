package com.thesett.accounts.test.taxTable;

import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.accounts.top.Main;
import com.thesett.test.base.DatabaseCRUDTestBase;
import com.thesett.util.dao.HibernateTransactionalProxy;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.TaxTableDAO;
import com.thesett.accounts.dao.TaxTableDAOImpl;
import com.thesett.accounts.model.TaxTable;

public class TaxTableDatabaseCRUDTest extends DatabaseCRUDTestBase<TaxTable, Long>
{
    public TaxTableDatabaseCRUDTest()
    {
        super(new TaxTableTestData(), TaxTable.class, new AppTestSetupController(), Main.class,
            ResourceUtils.resourceFilePath("config.yml"));
    }

    /** {@inheritDoc} */
    protected CRUD<TaxTable, Long> getDao()
    {
        return new TaxTableDAOImpl(sessionFactory, validatorFactory);
    }

    /** {@inheritDoc} */
    protected TaxTableDAO getTransactionalDAO()
    {
        TaxTableDAO taxTableDAO = new TaxTableDAOImpl(sessionFactory, validatorFactory);

        return HibernateTransactionalProxy.proxy(taxTableDAO, TaxTableDAO.class, sessionFactory);
    }
}
