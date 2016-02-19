package com.thesett.accounts.test.entry;

import com.thesett.test.base.JsonSerDesCRUDTestBase;

import com.thesett.accounts.model.Entry;    

public class EntryJsonSerDesCRUDTest extends JsonSerDesCRUDTestBase<Entry, Long>
{
    public EntryJsonSerDesCRUDTest()
    {
        super(new EntryTestData());
    }
}
