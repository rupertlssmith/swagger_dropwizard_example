package com.thesett.accounts.test.invoice;

import org.junit.Test;
import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.accounts.top.Main;
import com.thesett.test.base.FullStackCRUDTestBase;
import com.thesett.util.dao.HibernateSessionAndDetachProxy;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.InvoiceDAOImpl;
import com.thesett.accounts.model.Invoice;
import com.thesett.accounts.services.InvoiceService;
import com.thesett.accounts.services.rest.InvoiceResource;

public class InvoiceFullStackCRUDTest extends FullStackCRUDTestBase<Invoice, Long>
{
    public InvoiceFullStackCRUDTest()
    {
        super(new InvoiceTestData(), Invoice.class, new AppTestSetupController(), Main.class,
            ResourceUtils.resourceFilePath("config.yml"));
    }

    /** {@inheritDoc} */
    protected CRUD<Invoice, Long> getServiceLayer()
    {
        InvoiceDAOImpl invoiceDAO = new InvoiceDAOImpl(sessionFactory, validatorFactory);

        InvoiceResource invoiceResource = new InvoiceResource(invoiceDAO);

        return HibernateSessionAndDetachProxy.proxy(invoiceResource, InvoiceService.class, sessionFactory);
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
