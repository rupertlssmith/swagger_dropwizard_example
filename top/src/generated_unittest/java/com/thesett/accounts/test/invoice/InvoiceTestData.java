package com.thesett.accounts.test.invoice;

import java.util.LinkedList;
import java.util.List;

import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.test.stack.ModelEqualityByValue;
import com.thesett.test.stack.TestDataSupplierLongKey;

import com.thesett.accounts.model.Invoice;    

public class InvoiceTestData extends TestDataSupplierLongKey<Invoice>
{
    public InvoiceTestData()
    {
        initialValue = new Invoice();
        updatedValue = new Invoice();
    }

    /** {@inheritDoc} */
    public Invoice getDefaultValue()
    {
        return new Invoice();
    }

    /** {@inheritDoc} */
    public List<Invoice> examples()
    {
        return new LinkedList<Invoice>()
            {
                {
                }
            };
    }

    /** {@inheritDoc} */
    public List<Invoice> counterExamples()
    {
        return new LinkedList<Invoice>()
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
