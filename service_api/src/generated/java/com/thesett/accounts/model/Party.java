
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
public class Party  implements Entity<Long>, Serializable {

    /** Holds the database surrogate id. */
    private Long id;

    /** Holds the name property. */    
    protected String name;

    /** Holds the address property. */    
    protected Address address;

    /** Holds the type property. */    
    protected PartyType type;

    /** Holds the invoices property. */    
    protected List<Invoice> invoices;

    /** No-arg constructor for serialization. */
    public Party() {
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
    public Party withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Accepts a new value for the address property.
     *
     * @param address The address property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Party withAddress(Address address) {
        this.address = address;
        return this;
    }

    /**
     * Accepts a new value for the type property.
     *
     * @param type The type property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Party withType(PartyType type) {
        this.type = type;
        return this;
    }

    /**
     * Accepts a new value for the invoices property.
     *
     * @param invoices The invoices property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Party withInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
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
     * Provides the address property.
     *
     * @return The address property.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Provides the type property.
     *
     * @return The type property.
     */
    public PartyType getType() {
        return type;
    }

    /**
     * Provides the invoices property.
     *
     * @return The invoices property.
     */
    public List<Invoice> getInvoices() {
        return invoices;
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
     * Accepts a new value for the address property.
     *
     * @param address The address property.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Accepts a new value for the type property.
     *
     * @param type The type property.
     */
    public void setType(PartyType type) {
        this.type = type;
    }

    /**
     * Accepts a new value for the invoices property.
     *
     * @param invoices The invoices property.
     */
    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    
}
