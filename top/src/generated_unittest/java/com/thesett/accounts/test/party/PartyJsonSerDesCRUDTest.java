package com.thesett.accounts.test.party;

import com.thesett.test.base.JsonSerDesCRUDTestBase;

import com.thesett.accounts.model.Party;    

public class PartyJsonSerDesCRUDTest extends JsonSerDesCRUDTestBase<Party, Long>
{
    public PartyJsonSerDesCRUDTest()
    {
        super(new PartyTestData());
    }
}
