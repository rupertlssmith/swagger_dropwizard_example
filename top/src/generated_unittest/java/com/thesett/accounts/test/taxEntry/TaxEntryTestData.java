package com.thesett.accounts.test.taxEntry;

import java.util.LinkedList;
import java.util.List;

import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.test.stack.ModelEqualityByValue;
import com.thesett.test.stack.TestDataSupplierLongKey;

import com.thesett.accounts.model.TaxEntry;    

public class TaxEntryTestData extends TestDataSupplierLongKey<TaxEntry>
{
    public TaxEntryTestData()
    {
        initialValue = new TaxEntry();
        updatedValue = new TaxEntry();
    }

    /** {@inheritDoc} */
    public TaxEntry getDefaultValue()
    {
        return new TaxEntry();
    }

    /** {@inheritDoc} */
    public List<TaxEntry> examples()
    {
        return new LinkedList<TaxEntry>()
            {
                {
                }
            };
    }

    /** {@inheritDoc} */
    public List<TaxEntry> counterExamples()
    {
        return new LinkedList<TaxEntry>()
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
