package com.thesett.accounts.test.party;

import java.util.LinkedList;
import java.util.List;

import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.test.stack.ModelEqualityByValue;
import com.thesett.test.stack.TestDataSupplierLongKey;

import com.thesett.accounts.model.Party;    

public class PartyTestData extends TestDataSupplierLongKey<Party>
{
    public PartyTestData()
    {
        initialValue = new Party();
        updatedValue = new Party();
    }

    /** {@inheritDoc} */
    public Party getDefaultValue()
    {
        return new Party();
    }

    /** {@inheritDoc} */
    public List<Party> examples()
    {
        return new LinkedList<Party>()
            {
                {
                }
            };
    }

    /** {@inheritDoc} */
    public List<Party> counterExamples()
    {
        return new LinkedList<Party>()
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
