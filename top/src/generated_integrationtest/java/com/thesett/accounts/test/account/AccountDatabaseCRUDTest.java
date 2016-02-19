package com.thesett.accounts.test.account;

import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.accounts.top.Main;
import com.thesett.test.base.DatabaseCRUDTestBase;
import com.thesett.util.dao.HibernateTransactionalProxy;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.AccountDAO;
import com.thesett.accounts.dao.AccountDAOImpl;
import com.thesett.accounts.model.Account;

public class AccountDatabaseCRUDTest extends DatabaseCRUDTestBase<Account, Long>
{
    public AccountDatabaseCRUDTest()
    {
        super(new AccountTestData(), Account.class, new AppTestSetupController(), Main.class,
            ResourceUtils.resourceFilePath("config.yml"));
    }

    /** {@inheritDoc} */
    protected CRUD<Account, Long> getDao()
    {
        return new AccountDAOImpl(sessionFactory, validatorFactory);
    }

    /** {@inheritDoc} */
    protected AccountDAO getTransactionalDAO()
    {
        AccountDAO accountDAO = new AccountDAOImpl(sessionFactory, validatorFactory);

        return HibernateTransactionalProxy.proxy(accountDAO, AccountDAO.class, sessionFactory);
    }
}
