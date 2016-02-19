
package com.thesett.accounts.model;

import java.io.Serializable;

import java.util.List;


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
public class TaxTableRow  implements Entity<Long>, Serializable {

    /** Holds the database surrogate id. */
    private Long id;

    /** Holds the entries property. */    
    protected List<TaxTableEntry> entries;

    /** No-arg constructor for serialization. */
    public TaxTableRow() {
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
     * Accepts a new value for the entries property.
     *
     * @param entries The entries property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public TaxTableRow withEntries(List<TaxTableEntry> entries) {
        this.entries = entries;
        return this;
    }
    /**
     * Provides the entries property.
     *
     * @return The entries property.
     */
    public List<TaxTableEntry> getEntries() {
        return entries;
    }
    /**
     * Accepts a new value for the entries property.
     *
     * @param entries The entries property.
     */
    public void setEntries(List<TaxTableEntry> entries) {
        this.entries = entries;
    }

    
}
