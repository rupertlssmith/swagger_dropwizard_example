package com.thesett.accounts.test.entry;

import com.thesett.test.base.BaselineCRUDTestBase;

import com.thesett.accounts.model.Entry;    

public class EntryBaselineCRUDTest extends BaselineCRUDTestBase<Entry, Long>
{
    public EntryBaselineCRUDTest()
    {
        super(new EntryTestData());
    }
}
