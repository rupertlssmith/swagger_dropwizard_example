package com.thesett.accounts.test.entry;

import java.util.LinkedList;
import java.util.List;

import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.test.stack.ModelEqualityByValue;
import com.thesett.test.stack.TestDataSupplierLongKey;

import com.thesett.accounts.model.Entry;    

public class EntryTestData extends TestDataSupplierLongKey<Entry>
{
    public EntryTestData()
    {
        initialValue = new Entry();
        updatedValue = new Entry();
    }

    /** {@inheritDoc} */
    public Entry getDefaultValue()
    {
        return new Entry();
    }

    /** {@inheritDoc} */
    public List<Entry> examples()
    {
        return new LinkedList<Entry>()
            {
                {
                }
            };
    }

    /** {@inheritDoc} */
    public List<Entry> counterExamples()
    {
        return new LinkedList<Entry>()
            {
                {
                }
            };
    }

    /** {@inheritDoc} */
    public ModelEqualityByValue getEqualityChecker()
    {
        return AppTestSetupController.MODEL_EQUALITY_BY_VALUE;
    }
}
