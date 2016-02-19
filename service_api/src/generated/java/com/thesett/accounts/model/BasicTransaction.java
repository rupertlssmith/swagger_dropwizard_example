
package com.thesett.accounts.model;

import java.io.Serializable;

import java.util.List;
import org.joda.time.LocalDate;


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
public class BasicTransaction  implements Transaction, Entity<Long>, Serializable {

    /** Holds the database surrogate id. */
    private Long id;

    /** Holds the description property. */    
    protected String description;

    /** Holds the entries property. */    
    protected List<Entry> entries;

    /** Holds the date property. */    
    protected LocalDate date;

    /** Holds the invoice property. */    
    protected Invoice invoice;

    /** No-arg constructor for serialization. */
    public BasicTransaction() {
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
     * Accepts a new value for the description property.
     *
     * @param description The description property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public BasicTransaction withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Accepts a new value for the entries property.
     *
     * @param entries The entries property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public BasicTransaction withEntries(List<Entry> entries) {
        this.entries = entries;
        return this;
    }

    /**
     * Accepts a new value for the date property.
     *
     * @param date The date property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public BasicTransaction withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    /**
     * Accepts a new value for the invoice property.
     *
     * @param invoice The invoice property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public BasicTransaction withInvoice(Invoice invoice) {
        this.invoice = invoice;
        return this;
    }
    /**
     * Provides the description property.
     *
     * @return The description property.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Provides the entries property.
     *
     * @return The entries property.
     */
    public List<Entry> getEntries() {
        return entries;
    }

    /**
     * Provides the date property.
     *
     * @return The date property.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Provides the invoice property.
     *
     * @return The invoice property.
     */
    public Invoice getInvoice() {
        return invoice;
    }
    /**
     * Accepts a new value for the description property.
     *
     * @param description The description property.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Accepts a new value for the entries property.
     *
     * @param entries The entries property.
     */
    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    /**
     * Accepts a new value for the date property.
     *
     * @param date The date property.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Accepts a new value for the invoice property.
     *
     * @param invoice The invoice property.
     */
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    
}
