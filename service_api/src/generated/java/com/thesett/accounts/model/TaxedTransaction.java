
package com.thesett.accounts.model;

import java.util.List;


/**
 * Generated bean interface from catalogue model.
 *
 * @author Generated Code
 */
public interface TaxedTransaction {
    /**
     * Provides the taxEntries property.
     *
     * @return The taxEntries property.
     */
    List<TaxEntry> getTaxEntries();

    /**
     * Accepts a new value for the taxEntries property.
     *
     * @param taxEntries The taxEntries property.
     */
    void setTaxEntries(List<TaxEntry> taxEntries);
}
