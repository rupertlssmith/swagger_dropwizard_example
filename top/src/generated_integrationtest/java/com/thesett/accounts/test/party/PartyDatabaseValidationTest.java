package com.thesett.accounts.test.party;

import java.util.Collection;

import com.thesett.accounts.top.Main;
import org.junit.runners.Parameterized;
import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.test.base.DatabaseValidationTestBase;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.PartyDAOImpl;
import com.thesett.accounts.model.Party;

public class PartyDatabaseValidationTest extends DatabaseValidationTestBase<Party, Long>
{
    public PartyDatabaseValidationTest(Party example, boolean valid)
    {
        super(new PartyTestData(), Party.class, example, valid, new AppTestSetupController(),
            Main.class, ResourceUtils.resourceFilePath("config.yml"));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        return buildExamples(new PartyTestData());
    }

    /** {@inheritDoc} */
    protected CRUD<Party, Long> getDao()
    {
        return new PartyDAOImpl(sessionFactory, validatorFactory);
    }
}
