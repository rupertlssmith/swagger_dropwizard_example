
package com.thesett.accounts.model;

import java.io.Serializable;


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
public class TaxEntry  implements Entity<Long>, Serializable {

    /** Holds the database surrogate id. */
    private Long id;

    /** Holds the entry property. */    
    protected Entry entry;

    /** Holds the taxEntry property. */    
    protected TaxTableEntry taxEntry;

    /** No-arg constructor for serialization. */
    public TaxEntry() {
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
     * Accepts a new value for the entry property.
     *
     * @param entry The entry property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public TaxEntry withEntry(Entry entry) {
        this.entry = entry;
        return this;
    }

    /**
     * Accepts a new value for the taxEntry property.
     *
     * @param taxEntry The taxEntry property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public TaxEntry withTaxEntry(TaxTableEntry taxEntry) {
        this.taxEntry = taxEntry;
        return this;
    }
    /**
     * Provides the entry property.
     *
     * @return The entry property.
     */
    public Entry getEntry() {
        return entry;
    }

    /**
     * Provides the taxEntry property.
     *
     * @return The taxEntry property.
     */
    public TaxTableEntry getTaxEntry() {
        return taxEntry;
    }
    /**
     * Accepts a new value for the entry property.
     *
     * @param entry The entry property.
     */
    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    /**
     * Accepts a new value for the taxEntry property.
     *
     * @param taxEntry The taxEntry property.
     */
    public void setTaxEntry(TaxTableEntry taxEntry) {
        this.taxEntry = taxEntry;
    }

    
}
