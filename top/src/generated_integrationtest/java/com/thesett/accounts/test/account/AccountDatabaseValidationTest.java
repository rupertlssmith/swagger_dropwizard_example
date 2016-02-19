package com.thesett.accounts.test.account;

import java.util.Collection;

import com.thesett.accounts.top.Main;
import org.junit.runners.Parameterized;
import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.test.base.DatabaseValidationTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.AccountDAOImpl;
import com.thesett.accounts.model.Account;

public class AccountDatabaseValidationTest extends DatabaseValidationTestBase<Account, Long>
{
    public AccountDatabaseValidationTest(Account example, boolean valid)
    {
        super(new AccountTestData(), Account.class, example, valid, new AppTestSetupController(),
            Main.class, ResourceUtils.resourceFilePath("config.yml"));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        return buildExamples(new AccountTestData());
    }

    /** {@inheritDoc} */
    protected CRUD<Account, Long> getDao()
    {
        return new AccountDAOImpl(sessionFactory, validatorFactory);
    }
}
