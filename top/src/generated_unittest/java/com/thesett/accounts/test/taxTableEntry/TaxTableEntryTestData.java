package com.thesett.accounts.test.taxTableEntry;

import java.util.LinkedList;
import java.util.List;

import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.test.stack.ModelEqualityByValue;
import com.thesett.test.stack.TestDataSupplierLongKey;

import com.thesett.accounts.model.TaxTableEntry;    

public class TaxTableEntryTestData extends TestDataSupplierLongKey<TaxTableEntry>
{
    public TaxTableEntryTestData()
    {
        initialValue = new TaxTableEntry();
        updatedValue = new TaxTableEntry();
    }

    /** {@inheritDoc} */
    public TaxTableEntry getDefaultValue()
    {
        return new TaxTableEntry();
    }

    /** {@inheritDoc} */
    public List<TaxTableEntry> examples()
    {
        return new LinkedList<TaxTableEntry>()
            {
                {
                }
            };
    }

    /** {@inheritDoc} */
    public List<TaxTableEntry> counterExamples()
    {
        return new LinkedList<TaxTableEntry>()
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
