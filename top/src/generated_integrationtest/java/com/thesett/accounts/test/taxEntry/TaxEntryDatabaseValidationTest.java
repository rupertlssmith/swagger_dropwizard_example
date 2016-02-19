package com.thesett.accounts.test.taxEntry;

import java.util.Collection;

import com.thesett.accounts.top.Main;
import org.junit.runners.Parameterized;
import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.test.base.DatabaseValidationTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.TaxEntryDAOImpl;
import com.thesett.accounts.model.TaxEntry;

public class TaxEntryDatabaseValidationTest extends DatabaseValidationTestBase<TaxEntry, Long>
{
    public TaxEntryDatabaseValidationTest(TaxEntry example, boolean valid)
    {
        super(new TaxEntryTestData(), TaxEntry.class, example, valid, new AppTestSetupController(),
            Main.class, ResourceUtils.resourceFilePath("config.yml"));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        return buildExamples(new TaxEntryTestData());
    }

    /** {@inheritDoc} */
    protected CRUD<TaxEntry, Long> getDao()
    {
        return new TaxEntryDAOImpl(sessionFactory, validatorFactory);
    }
}
