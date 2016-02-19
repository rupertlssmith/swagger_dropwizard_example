package com.thesett.accounts.test.account;

import java.util.LinkedList;
import java.util.List;

import com.thesett.accounts.test.AppTestSetupController;
import com.thesett.test.stack.ModelEqualityByValue;
import com.thesett.test.stack.TestDataSupplierLongKey;

import com.thesett.accounts.model.Account;    

public class AccountTestData extends TestDataSupplierLongKey<Account>
{
    public AccountTestData()
    {
        initialValue = new Account();
        updatedValue = new Account();
    }

    /** {@inheritDoc} */
    public Account getDefaultValue()
    {
        return new Account();
    }

    /** {@inheritDoc} */
    public List<Account> examples()
    {
        return new LinkedList<Account>()
            {
                {
                }
            };
    }

    /** {@inheritDoc} */
    public List<Account> counterExamples()
    {
        return new LinkedList<Account>()
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
