package com.thesett.accounts.test.taxTable;

import java.util.Collection;

import com.thesett.accounts.top.Main;
import org.junit.runners.Parameterized;
import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.test.base.DatabaseValidationTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.TaxTableDAOImpl;
import com.thesett.accounts.model.TaxTable;

public class TaxTableDatabaseValidationTest extends DatabaseValidationTestBase<TaxTable, Long>
{
    public TaxTableDatabaseValidationTest(TaxTable example, boolean valid)
    {
        super(new TaxTableTestData(), TaxTable.class, example, valid, new AppTestSetupController(),
            Main.class, ResourceUtils.resourceFilePath("config.yml"));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        return buildExamples(new TaxTableTestData());
    }

    /** {@inheritDoc} */
    protected CRUD<TaxTable, Long> getDao()
    {
        return new TaxTableDAOImpl(sessionFactory, validatorFactory);
    }
}
