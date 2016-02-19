package com.thesett.accounts.test.account;

import org.junit.Test;
import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.accounts.top.Main;
import com.thesett.test.base.FullStackCRUDTestBase;
import com.thesett.util.dao.HibernateSessionAndDetachProxy;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.AccountDAOImpl;
import com.thesett.accounts.model.Account;
import com.thesett.accounts.services.AccountService;
import com.thesett.accounts.services.rest.AccountResource;

public class AccountFullStackCRUDTest extends FullStackCRUDTestBase<Account, Long>
{
    public AccountFullStackCRUDTest()
    {
        super(new AccountTestData(), Account.class, new AppTestSetupController(), Main.class,
            ResourceUtils.resourceFilePath("config.yml"));
    }

    /** {@inheritDoc} */
    protected CRUD<Account, Long> getServiceLayer()
    {
        AccountDAOImpl accountDAO = new AccountDAOImpl(sessionFactory, validatorFactory);

        AccountResource accountResource = new AccountResource(accountDAO);

        return HibernateSessionAndDetachProxy.proxy(accountResource, AccountService.class, sessionFactory);
    }

    @Test
    public void testFindAllNotEmpty() throws Exception {
        testFindAllNotEmpty("findAll");
    }

    @Test
    public void testFindByExampleNotEmpty() throws Exception {
        testFindByExampleNotEmpty("findByExample");
    }

    @Test
    public void testJsonSchema() throws Exception {
        testJsonSchema("schema");
    }

    @Test
    public void testRootHal() throws Exception {
        testRootHal("root");
    }
}
