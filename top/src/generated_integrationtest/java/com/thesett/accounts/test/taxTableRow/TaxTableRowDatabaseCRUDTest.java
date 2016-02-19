package com.thesett.accounts.test.taxTableRow;

import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.accounts.top.Main;
import com.thesett.test.base.DatabaseCRUDTestBase;
import com.thesett.util.dao.HibernateTransactionalProxy;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.TaxTableRowDAO;
import com.thesett.accounts.dao.TaxTableRowDAOImpl;
import com.thesett.accounts.model.TaxTableRow;

public class TaxTableRowDatabaseCRUDTest extends DatabaseCRUDTestBase<TaxTableRow, Long>
{
    public TaxTableRowDatabaseCRUDTest()
    {
        super(new TaxTableRowTestData(), TaxTableRow.class, new AppTestSetupController(), Main.class,
            ResourceUtils.resourceFilePath("config.yml"));
    }

    /** {@inheritDoc} */
    protected CRUD<TaxTableRow, Long> getDao()
    {
        return new TaxTableRowDAOImpl(sessionFactory, validatorFactory);
    }

    /** {@inheritDoc} */
    protected TaxTableRowDAO getTransactionalDAO()
    {
        TaxTableRowDAO taxTableRowDAO = new TaxTableRowDAOImpl(sessionFactory, validatorFactory);

        return HibernateTransactionalProxy.proxy(taxTableRowDAO, TaxTableRowDAO.class, sessionFactory);
    }
}
