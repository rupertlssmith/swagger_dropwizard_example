package com.thesett.accounts.test.basicTransaction;

import java.util.LinkedList;
import java.util.List;

import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.test.stack.ModelEqualityByValue;
import com.thesett.test.stack.TestDataSupplierLongKey;

import com.thesett.accounts.model.BasicTransaction;    

public class BasicTransactionTestData extends TestDataSupplierLongKey<BasicTransaction>
{
    public BasicTransactionTestData()
    {
        initialValue = new BasicTransaction();
        updatedValue = new BasicTransaction();
    }

    /** {@inheritDoc} */
    public BasicTransaction getDefaultValue()
    {
        return new BasicTransaction();
    }

    /** {@inheritDoc} */
    public List<BasicTransaction> examples()
    {
        return new LinkedList<BasicTransaction>()
            {
                {
                }
            };
    }

    /** {@inheritDoc} */
    public List<BasicTransaction> counterExamples()
    {
        return new LinkedList<BasicTransaction>()
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
