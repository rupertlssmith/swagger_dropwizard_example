package com.thesett.accounts.test.invoice;

import java.util.Collection;

import com.thesett.accounts.top.Main;
import org.junit.runners.Parameterized;
import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.test.base.DatabaseValidationTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.InvoiceDAOImpl;
import com.thesett.accounts.model.Invoice;

public class InvoiceDatabaseValidationTest extends DatabaseValidationTestBase<Invoice, Long>
{
    public InvoiceDatabaseValidationTest(Invoice example, boolean valid)
    {
        super(new InvoiceTestData(), Invoice.class, example, valid, new AppTestSetupController(),
            Main.class, ResourceUtils.resourceFilePath("config.yml"));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        return buildExamples(new InvoiceTestData());
    }

    /** {@inheritDoc} */
    protected CRUD<Invoice, Long> getDao()
    {
        return new InvoiceDAOImpl(sessionFactory, validatorFactory);
    }
}
