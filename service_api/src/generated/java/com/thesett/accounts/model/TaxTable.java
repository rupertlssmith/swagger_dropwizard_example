
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
public class TaxTable  implements Entity<Long>, Serializable {

    /** Holds the database surrogate id. */
    private Long id;

    /** Holds the name property. */    
    protected String name;

    /** Holds the rows property. */    
    protected List<TaxTableRow> rows;

    /** No-arg constructor for serialization. */
    public TaxTable() {
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
     * Accepts a new value for the name property.
     *
     * @param name The name property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public TaxTable withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Accepts a new value for the rows property.
     *
     * @param rows The rows property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public TaxTable withRows(List<TaxTableRow> rows) {
        this.rows = rows;
        return this;
    }
    /**
     * Provides the name property.
     *
     * @return The name property.
     */
    public String getName() {
        return name;
    }

    /**
     * Provides the rows property.
     *
     * @return The rows property.
     */
    public List<TaxTableRow> getRows() {
        return rows;
    }
    /**
     * Accepts a new value for the name property.
     *
     * @param name The name property.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Accepts a new value for the rows property.
     *
     * @param rows The rows property.
     */
    public void setRows(List<TaxTableRow> rows) {
        this.rows = rows;
    }

    
}
