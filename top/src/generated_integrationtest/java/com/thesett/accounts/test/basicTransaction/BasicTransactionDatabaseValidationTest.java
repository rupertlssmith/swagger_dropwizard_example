package com.thesett.accounts.test.basicTransaction;

import java.util.Collection;

import com.thesett.accounts.top.Main;
import org.junit.runners.Parameterized;
import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.test.base.DatabaseValidationTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.BasicTransactionDAOImpl;
import com.thesett.accounts.model.BasicTransaction;

public class BasicTransactionDatabaseValidationTest extends DatabaseValidationTestBase<BasicTransaction, Long>
{
    public BasicTransactionDatabaseValidationTest(BasicTransaction example, boolean valid)
    {
        super(new BasicTransactionTestData(), BasicTransaction.class, example, valid, new AppTestSetupController(),
            Main.class, ResourceUtils.resourceFilePath("config.yml"));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        return buildExamples(new BasicTransactionTestData());
    }

    /** {@inheritDoc} */
    protected CRUD<BasicTransaction, Long> getDao()
    {
        return new BasicTransactionDAOImpl(sessionFactory, validatorFactory);
    }
}
