package com.thesett.accounts.test.entry;

import org.junit.Test;
import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.accounts.top.Main;
import com.thesett.test.base.FullStackCRUDTestBase;
import com.thesett.util.dao.HibernateSessionAndDetachProxy;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.EntryDAOImpl;
import com.thesett.accounts.model.Entry;
import com.thesett.accounts.services.EntryService;
import com.thesett.accounts.services.rest.EntryResource;

public class EntryFullStackCRUDTest extends FullStackCRUDTestBase<Entry, Long>
{
    public EntryFullStackCRUDTest()
    {
        super(new EntryTestData(), Entry.class, new AppTestSetupController(), Main.class,
            ResourceUtils.resourceFilePath("config.yml"));
    }

    /** {@inheritDoc} */
    protected CRUD<Entry, Long> getServiceLayer()
    {
        EntryDAOImpl entryDAO = new EntryDAOImpl(sessionFactory, validatorFactory);

        EntryResource entryResource = new EntryResource(entryDAO);

        return HibernateSessionAndDetachProxy.proxy(entryResource, EntryService.class, sessionFactory);
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
