
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
public class Invoice  implements Transaction,TaxedTransaction,Payable, Entity<Long>, Serializable {

    /** Holds the database surrogate id. */
    private Long id;

    /** Holds the description property. */    
    protected String description;

    /** Holds the invoiceNumber property. */    
    protected Integer invoiceNumber;

    /** Holds the entries property. */    
    protected List<Entry> entries;

    /** Holds the taxEntries property. */    
    protected List<TaxEntry> taxEntries;

    /** Holds the date property. */    
    protected LocalDate date;

    /** Holds the due_date property. */    
    protected LocalDate dueDate;

    /** Holds the postingEntry property. */    
    protected Entry postingEntry;

    /** Holds the payment property. */    
    protected BasicTransaction payment;

    /** Holds the party property. */    
    protected Party party;

    /** No-arg constructor for serialization. */
    public Invoice() {
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
    public Invoice withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Accepts a new value for the invoiceNumber property.
     *
     * @param invoiceNumber The invoiceNumber property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Invoice withInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }

    /**
     * Accepts a new value for the entries property.
     *
     * @param entries The entries property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Invoice withEntries(List<Entry> entries) {
        this.entries = entries;
        return this;
    }

    /**
     * Accepts a new value for the taxEntries property.
     *
     * @param taxEntries The taxEntries property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Invoice withTaxEntries(List<TaxEntry> taxEntries) {
        this.taxEntries = taxEntries;
        return this;
    }

    /**
     * Accepts a new value for the date property.
     *
     * @param date The date property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Invoice withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    /**
     * Accepts a new value for the due_date property.
     *
     * @param dueDate The due_date property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Invoice withDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    /**
     * Accepts a new value for the postingEntry property.
     *
     * @param postingEntry The postingEntry property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Invoice withPostingEntry(Entry postingEntry) {
        this.postingEntry = postingEntry;
        return this;
    }

    /**
     * Accepts a new value for the payment property.
     *
     * @param payment The payment property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Invoice withPayment(BasicTransaction payment) {
        this.payment = payment;
        return this;
    }

    /**
     * Accepts a new value for the party property.
     *
     * @param party The party property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Invoice withParty(Party party) {
        this.party = party;
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
     * Provides the invoiceNumber property.
     *
     * @return The invoiceNumber property.
     */
    public Integer getInvoiceNumber() {
        return invoiceNumber;
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
     * Provides the taxEntries property.
     *
     * @return The taxEntries property.
     */
    public List<TaxEntry> getTaxEntries() {
        return taxEntries;
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
     * Provides the due_date property.
     *
     * @return The due_date property.
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Provides the postingEntry property.
     *
     * @return The postingEntry property.
     */
    public Entry getPostingEntry() {
        return postingEntry;
    }

    /**
     * Provides the payment property.
     *
     * @return The payment property.
     */
    public BasicTransaction getPayment() {
        return payment;
    }

    /**
     * Provides the party property.
     *
     * @return The party property.
     */
    public Party getParty() {
        return party;
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
     * Accepts a new value for the invoiceNumber property.
     *
     * @param invoiceNumber The invoiceNumber property.
     */
    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
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
     * Accepts a new value for the taxEntries property.
     *
     * @param taxEntries The taxEntries property.
     */
    public void setTaxEntries(List<TaxEntry> taxEntries) {
        this.taxEntries = taxEntries;
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
     * Accepts a new value for the due_date property.
     *
     * @param dueDate The due_date property.
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Accepts a new value for the postingEntry property.
     *
     * @param postingEntry The postingEntry property.
     */
    public void setPostingEntry(Entry postingEntry) {
        this.postingEntry = postingEntry;
    }

    /**
     * Accepts a new value for the payment property.
     *
     * @param payment The payment property.
     */
    public void setPayment(BasicTransaction payment) {
        this.payment = payment;
    }

    /**
     * Accepts a new value for the party property.
     *
     * @param party The party property.
     */
    public void setParty(Party party) {
        this.party = party;
    }

    
}
