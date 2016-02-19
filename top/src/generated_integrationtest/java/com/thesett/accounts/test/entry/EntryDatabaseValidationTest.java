package com.thesett.accounts.test.entry;

import java.util.Collection;

import com.thesett.accounts.top.Main;
import org.junit.runners.Parameterized;
import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.test.base.DatabaseValidationTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.EntryDAOImpl;
import com.thesett.accounts.model.Entry;

public class EntryDatabaseValidationTest extends DatabaseValidationTestBase<Entry, Long>
{
    public EntryDatabaseValidationTest(Entry example, boolean valid)
    {
        super(new EntryTestData(), Entry.class, example, valid, new AppTestSetupController(),
            Main.class, ResourceUtils.resourceFilePath("config.yml"));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        return buildExamples(new EntryTestData());
    }

    /** {@inheritDoc} */
    protected CRUD<Entry, Long> getDao()
    {
        return new EntryDAOImpl(sessionFactory, validatorFactory);
    }
}
