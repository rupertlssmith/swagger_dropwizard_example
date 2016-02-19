package com.thesett.accounts.test.taxTable;

import org.junit.Test;
import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.accounts.top.Main;
import com.thesett.test.base.FullStackCRUDTestBase;
import com.thesett.util.dao.HibernateSessionAndDetachProxy;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.TaxTableDAOImpl;
import com.thesett.accounts.model.TaxTable;
import com.thesett.accounts.services.TaxTableService;
import com.thesett.accounts.services.rest.TaxTableResource;

public class TaxTableFullStackCRUDTest extends FullStackCRUDTestBase<TaxTable, Long>
{
    public TaxTableFullStackCRUDTest()
    {
        super(new TaxTableTestData(), TaxTable.class, new AppTestSetupController(), Main.class,
            ResourceUtils.resourceFilePath("config.yml"));
    }

    /** {@inheritDoc} */
    protected CRUD<TaxTable, Long> getServiceLayer()
    {
        TaxTableDAOImpl taxTableDAO = new TaxTableDAOImpl(sessionFactory, validatorFactory);

        TaxTableResource taxTableResource = new TaxTableResource(taxTableDAO);

        return HibernateSessionAndDetachProxy.proxy(taxTableResource, TaxTableService.class, sessionFactory);
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
