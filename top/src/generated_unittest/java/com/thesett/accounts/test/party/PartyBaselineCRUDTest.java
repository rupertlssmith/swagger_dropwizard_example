package com.thesett.accounts.test.party;

import com.thesett.test.base.BaselineCRUDTestBase;

import com.thesett.accounts.model.Party;    

public class PartyBaselineCRUDTest extends BaselineCRUDTestBase<Party, Long>
{
    public PartyBaselineCRUDTest()
    {
        super(new PartyTestData());
    }
}
