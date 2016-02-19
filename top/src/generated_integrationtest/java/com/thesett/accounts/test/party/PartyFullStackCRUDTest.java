package com.thesett.accounts.test.party;

import org.junit.Test;
import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.accounts.top.Main;
import com.thesett.test.base.FullStackCRUDTestBase;
import com.thesett.util.dao.HibernateSessionAndDetachProxy;
import com.thesett.util.entity.CRUD;
import com.thesett.util.resource.ResourceUtils;

import com.thesett.accounts.dao.PartyDAOImpl;
import com.thesett.accounts.model.Party;
import com.thesett.accounts.services.PartyService;
import com.thesett.accounts.services.rest.PartyResource;

public class PartyFullStackCRUDTest extends FullStackCRUDTestBase<Party, Long>
{
    public PartyFullStackCRUDTest()
    {
        super(new PartyTestData(), Party.class, new AppTestSetupController(), Main.class,
            ResourceUtils.resourceFilePath("config.yml"));
    }

    /** {@inheritDoc} */
    protected CRUD<Party, Long> getServiceLayer()
    {
        PartyDAOImpl partyDAO = new PartyDAOImpl(sessionFactory, validatorFactory);

        PartyResource partyResource = new PartyResource(partyDAO);

        return HibernateSessionAndDetachProxy.proxy(partyResource, PartyService.class, sessionFactory);
    }

    @Test
    public void testFindAllNotEmpty() throws Exception {
        testFindAllNotEmpty("findAll");
    }

    @Test
    public void testFindByExampleNotEmpty() throws Exception {
        testFindByExampleNotEmpty("findByExample");
    }

    @Test
    public void testJsonSchema() throws Exception {
        testJsonSchema("schema");
    }

    @Test
    public void testRootHal() throws Exception {
        testRootHal("root");
    }
}
