
package com.thesett.accounts.model;

import java.io.Serializable;

import java.util.Set;
import java.math.BigDecimal;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.thesett.util.entity.Entity;

    
    

/**
 * Generated bean from catalogue model.    
 *
 * @author Generated Code
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Entry  implements Entity<Long>, Serializable {

    /** Holds the database surrogate id. */
    private Long id;

    /** Holds the account property. */    
    protected Account account;

    /** Holds the amount property. */    
    protected BigDecimal amount;

    /** Holds the status property. */    
    protected EntryStatusType status;

    /** Holds the taxEntries property. */    
    protected Set<TaxEntry> taxEntries;

    /** No-arg constructor for serialization. */
    public Entry() {
        // No-arg constructor for serialization.
    }

        

    /**
     * Gets the database surrogate id.
     *
     * @return The database surrogate id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the database surrogate id.
     *
     * @param id The database surrogate id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    
    /**
     * Accepts a new value for the account property.
     *
     * @param account The account property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Entry withAccount(Account account) {
        this.account = account;
        return this;
    }

    /**
     * Accepts a new value for the amount property.
     *
     * @param amount The amount property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Entry withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Accepts a new value for the status property.
     *
     * @param status The status property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Entry withStatus(EntryStatusType status) {
        this.status = status;
        return this;
    }

    /**
     * Accepts a new value for the taxEntries property.
     *
     * @param taxEntries The taxEntries property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Entry withTaxEntries(Set<TaxEntry> taxEntries) {
        this.taxEntries = taxEntries;
        return this;
    }
    /**
     * Provides the account property.
     *
     * @return The account property.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Provides the amount property.
     *
     * @return The amount property.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Provides the status property.
     *
     * @return The status property.
     */
    public EntryStatusType getStatus() {
        return status;
    }

    /**
     * Provides the taxEntries property.
     *
     * @return The taxEntries property.
     */
    public Set<TaxEntry> getTaxEntries() {
        return taxEntries;
    }
    /**
     * Accepts a new value for the account property.
     *
     * @param account The account property.
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * Accepts a new value for the amount property.
     *
     * @param amount The amount property.
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Accepts a new value for the status property.
     *
     * @param status The status property.
     */
    public void setStatus(EntryStatusType status) {
        this.status = status;
    }

    /**
     * Accepts a new value for the taxEntries property.
     *
     * @param taxEntries The taxEntries property.
     */
    public void setTaxEntries(Set<TaxEntry> taxEntries) {
        this.taxEntries = taxEntries;
    }

    
}
