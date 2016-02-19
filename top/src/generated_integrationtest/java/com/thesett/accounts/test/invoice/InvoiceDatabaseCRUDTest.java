package com.thesett.accounts.test.invoice;

import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.accounts.top.Main;
import com.thesett.test.base.DatabaseCRUDTestBase;
import com.thesett.util.dao.HibernateTransactionalProxy;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.InvoiceDAO;
import com.thesett.accounts.dao.InvoiceDAOImpl;
import com.thesett.accounts.model.Invoice;

public class InvoiceDatabaseCRUDTest extends DatabaseCRUDTestBase<Invoice, Long>
{
    public InvoiceDatabaseCRUDTest()
    {
        super(new InvoiceTestData(), Invoice.class, new AppTestSetupController(), Main.class,
            ResourceUtils.resourceFilePath("config.yml"));
    }

    /** {@inheritDoc} */
    protected CRUD<Invoice, Long> getDao()
    {
        return new InvoiceDAOImpl(sessionFactory, validatorFactory);
    }

    /** {@inheritDoc} */
    protected InvoiceDAO getTransactionalDAO()
    {
        InvoiceDAO invoiceDAO = new InvoiceDAOImpl(sessionFactory, validatorFactory);

        return HibernateTransactionalProxy.proxy(invoiceDAO, InvoiceDAO.class, sessionFactory);
    }
}
