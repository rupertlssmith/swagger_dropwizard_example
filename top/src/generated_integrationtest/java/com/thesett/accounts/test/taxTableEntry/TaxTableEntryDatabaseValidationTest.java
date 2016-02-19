package com.thesett.accounts.test.taxTableEntry;

import java.util.Collection;

import com.thesett.accounts.top.Main;
import org.junit.runners.Parameterized;
import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.test.base.DatabaseValidationTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.TaxTableEntryDAOImpl;
import com.thesett.accounts.model.TaxTableEntry;

public class TaxTableEntryDatabaseValidationTest extends DatabaseValidationTestBase<TaxTableEntry, Long>
{
    public TaxTableEntryDatabaseValidationTest(TaxTableEntry example, boolean valid)
    {
        super(new TaxTableEntryTestData(), TaxTableEntry.class, example, valid, new AppTestSetupController(),
            Main.class, ResourceUtils.resourceFilePath("config.yml"));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        return buildExamples(new TaxTableEntryTestData());
    }

    /** {@inheritDoc} */
    protected CRUD<TaxTableEntry, Long> getDao()
    {
        return new TaxTableEntryDAOImpl(sessionFactory, validatorFactory);
    }
}
