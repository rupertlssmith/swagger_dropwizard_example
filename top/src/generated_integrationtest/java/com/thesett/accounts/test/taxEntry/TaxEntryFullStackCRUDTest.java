package com.thesett.accounts.test.taxEntry;

import org.junit.Test;
import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.accounts.top.Main;
import com.thesett.test.base.FullStackCRUDTestBase;
import com.thesett.util.dao.HibernateSessionAndDetachProxy;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.TaxEntryDAOImpl;
import com.thesett.accounts.model.TaxEntry;
import com.thesett.accounts.services.TaxEntryService;
import com.thesett.accounts.services.rest.TaxEntryResource;

public class TaxEntryFullStackCRUDTest extends FullStackCRUDTestBase<TaxEntry, Long>
{
    public TaxEntryFullStackCRUDTest()
    {
        super(new TaxEntryTestData(), TaxEntry.class, new AppTestSetupController(), Main.class,
            ResourceUtils.resourceFilePath("config.yml"));
    }

    /** {@inheritDoc} */
    protected CRUD<TaxEntry, Long> getServiceLayer()
    {
        TaxEntryDAOImpl taxEntryDAO = new TaxEntryDAOImpl(sessionFactory, validatorFactory);

        TaxEntryResource taxEntryResource = new TaxEntryResource(taxEntryDAO);

        return HibernateSessionAndDetachProxy.proxy(taxEntryResource, TaxEntryService.class, sessionFactory);
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
