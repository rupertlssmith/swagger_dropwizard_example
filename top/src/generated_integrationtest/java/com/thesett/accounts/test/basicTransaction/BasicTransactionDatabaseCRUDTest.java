package com.thesett.accounts.test.basicTransaction;

import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.accounts.top.Main;
import com.thesett.test.base.DatabaseCRUDTestBase;
import com.thesett.util.dao.HibernateTransactionalProxy;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.BasicTransactionDAO;
import com.thesett.accounts.dao.BasicTransactionDAOImpl;
import com.thesett.accounts.model.BasicTransaction;

public class BasicTransactionDatabaseCRUDTest extends DatabaseCRUDTestBase<BasicTransaction, Long>
{
    public BasicTransactionDatabaseCRUDTest()
    {
        super(new BasicTransactionTestData(), BasicTransaction.class, new AppTestSetupController(), Main.class,
            ResourceUtils.resourceFilePath("config.yml"));
    }

    /** {@inheritDoc} */
    protected CRUD<BasicTransaction, Long> getDao()
    {
        return new BasicTransactionDAOImpl(sessionFactory, validatorFactory);
    }

    /** {@inheritDoc} */
    protected BasicTransactionDAO getTransactionalDAO()
    {
        BasicTransactionDAO basicTransactionDAO = new BasicTransactionDAOImpl(sessionFactory, validatorFactory);

        return HibernateTransactionalProxy.proxy(basicTransactionDAO, BasicTransactionDAO.class, sessionFactory);
    }
}
