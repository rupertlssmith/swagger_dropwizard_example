package com.thesett.accounts.test.taxTableRow;

import java.util.Collection;

import com.thesett.accounts.top.Main;
import org.junit.runners.Parameterized;
import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.test.base.DatabaseValidationTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.TaxTableRowDAOImpl;
import com.thesett.accounts.model.TaxTableRow;

public class TaxTableRowDatabaseValidationTest extends DatabaseValidationTestBase<TaxTableRow, Long>
{
    public TaxTableRowDatabaseValidationTest(TaxTableRow example, boolean valid)
    {
        super(new TaxTableRowTestData(), TaxTableRow.class, example, valid, new AppTestSetupController(),
            Main.class, ResourceUtils.resourceFilePath("config.yml"));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        return buildExamples(new TaxTableRowTestData());
    }

    /** {@inheritDoc} */
    protected CRUD<TaxTableRow, Long> getDao()
    {
        return new TaxTableRowDAOImpl(sessionFactory, validatorFactory);
    }
}
