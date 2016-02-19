package com.thesett.accounts.test.taxTableEntry;

import org.junit.Test;
import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.accounts.top.Main;
import com.thesett.test.base.FullStackCRUDTestBase;
import com.thesett.util.dao.HibernateSessionAndDetachProxy;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.TaxTableEntryDAOImpl;
import com.thesett.accounts.model.TaxTableEntry;
import com.thesett.accounts.services.TaxTableEntryService;
import com.thesett.accounts.services.rest.TaxTableEntryResource;

public class TaxTableEntryFullStackCRUDTest extends FullStackCRUDTestBase<TaxTableEntry, Long>
{
    public TaxTableEntryFullStackCRUDTest()
    {
        super(new TaxTableEntryTestData(), TaxTableEntry.class, new AppTestSetupController(), Main.class,
            ResourceUtils.resourceFilePath("config.yml"));
    }

    /** {@inheritDoc} */
    protected CRUD<TaxTableEntry, Long> getServiceLayer()
    {
        TaxTableEntryDAOImpl taxTableEntryDAO = new TaxTableEntryDAOImpl(sessionFactory, validatorFactory);

        TaxTableEntryResource taxTableEntryResource = new TaxTableEntryResource(taxTableEntryDAO);

        return HibernateSessionAndDetachProxy.proxy(taxTableEntryResource, TaxTableEntryService.class, sessionFactory);
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
