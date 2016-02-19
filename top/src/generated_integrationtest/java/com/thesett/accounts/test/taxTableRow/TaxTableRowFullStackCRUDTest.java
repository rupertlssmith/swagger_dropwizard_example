package com.thesett.accounts.test.taxTableRow;

import org.junit.Test;
import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.accounts.top.Main;
import com.thesett.test.base.FullStackCRUDTestBase;
import com.thesett.util.dao.HibernateSessionAndDetachProxy;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.TaxTableRowDAOImpl;
import com.thesett.accounts.model.TaxTableRow;
import com.thesett.accounts.services.TaxTableRowService;
import com.thesett.accounts.services.rest.TaxTableRowResource;

public class TaxTableRowFullStackCRUDTest extends FullStackCRUDTestBase<TaxTableRow, Long>
{
    public TaxTableRowFullStackCRUDTest()
    {
        super(new TaxTableRowTestData(), TaxTableRow.class, new AppTestSetupController(), Main.class,
            ResourceUtils.resourceFilePath("config.yml"));
    }

    /** {@inheritDoc} */
    protected CRUD<TaxTableRow, Long> getServiceLayer()
    {
        TaxTableRowDAOImpl taxTableRowDAO = new TaxTableRowDAOImpl(sessionFactory, validatorFactory);

        TaxTableRowResource taxTableRowResource = new TaxTableRowResource(taxTableRowDAO);

        return HibernateSessionAndDetachProxy.proxy(taxTableRowResource, TaxTableRowService.class, sessionFactory);
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
