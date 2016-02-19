package com.thesett.accounts.test.basicTransaction;

import org.junit.Test;
import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.accounts.top.Main;
import com.thesett.test.base.FullStackCRUDTestBase;
import com.thesett.util.dao.HibernateSessionAndDetachProxy;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.BasicTransactionDAOImpl;
import com.thesett.accounts.model.BasicTransaction;
import com.thesett.accounts.services.BasicTransactionService;
import com.thesett.accounts.services.rest.BasicTransactionResource;

public class BasicTransactionFullStackCRUDTest extends FullStackCRUDTestBase<BasicTransaction, Long>
{
    public BasicTransactionFullStackCRUDTest()
    {
        super(new BasicTransactionTestData(), BasicTransaction.class, new AppTestSetupController(), Main.class,
            ResourceUtils.resourceFilePath("config.yml"));
    }

    /** {@inheritDoc} */
    protected CRUD<BasicTransaction, Long> getServiceLayer()
    {
        BasicTransactionDAOImpl basicTransactionDAO = new BasicTransactionDAOImpl(sessionFactory, validatorFactory);

        BasicTransactionResource basicTransactionResource = new BasicTransactionResource(basicTransactionDAO);

        return HibernateSessionAndDetachProxy.proxy(basicTransactionResource, BasicTransactionService.class, sessionFactory);
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
