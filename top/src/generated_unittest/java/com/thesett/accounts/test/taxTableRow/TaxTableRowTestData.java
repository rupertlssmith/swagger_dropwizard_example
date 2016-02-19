package com.thesett.accounts.test.taxTableRow;

import java.util.LinkedList;
import java.util.List;

import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.test.stack.ModelEqualityByValue;
import com.thesett.test.stack.TestDataSupplierLongKey;

import com.thesett.accounts.model.TaxTableRow;    

public class TaxTableRowTestData extends TestDataSupplierLongKey<TaxTableRow>
{
    public TaxTableRowTestData()
    {
        initialValue = new TaxTableRow();
        updatedValue = new TaxTableRow();
    }

    /** {@inheritDoc} */
    public TaxTableRow getDefaultValue()
    {
        return new TaxTableRow();
    }

    /** {@inheritDoc} */
    public List<TaxTableRow> examples()
    {
        return new LinkedList<TaxTableRow>()
            {
                {
                }
            };
    }

    /** {@inheritDoc} */
    public List<TaxTableRow> counterExamples()
    {
        return new LinkedList<TaxTableRow>()
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
