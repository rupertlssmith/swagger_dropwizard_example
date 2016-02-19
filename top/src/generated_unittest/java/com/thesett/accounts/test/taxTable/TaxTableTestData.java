package com.thesett.accounts.test.taxTable;

import java.util.LinkedList;
import java.util.List;

import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.test.stack.ModelEqualityByValue;
import com.thesett.test.stack.TestDataSupplierLongKey;

import com.thesett.accounts.model.TaxTable;    

public class TaxTableTestData extends TestDataSupplierLongKey<TaxTable>
{
    public TaxTableTestData()
    {
        initialValue = new TaxTable();
        updatedValue = new TaxTable();
    }

    /** {@inheritDoc} */
    public TaxTable getDefaultValue()
    {
        return new TaxTable();
    }

    /** {@inheritDoc} */
    public List<TaxTable> examples()
    {
        return new LinkedList<TaxTable>()
            {
                {
                }
            };
    }

    /** {@inheritDoc} */
    public List<TaxTable> counterExamples()
    {
        return new LinkedList<TaxTable>()
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
