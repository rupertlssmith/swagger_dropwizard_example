
package com.thesett.accounts.model;

import java.io.Serializable;

import java.util.Set;
import java.util.List;
import java.math.BigDecimal;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.thesett.util.entity.Entity;

    
import com.thesett.util.equality.EqualityHelper;
    

/**
 * Generated bean from catalogue model.

 *
 * <p/>Equality (and hashCode) is based on the following fields:
 *
 * <pre><p/><table id="equality"><caption>Equality Fields</caption>
 * <tr><th> Field Name </th></tr>
* <tr><td> name </tr></td>
* <tr><td> parentAccount </tr></td>
 * </table></pre>    
 *
 * @author Generated Code
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Account  implements Entity<Long>, Serializable {

    /** Holds the database surrogate id. */
    private Long id;

    /** Holds the name property. */    
    protected String name;

    /** Holds the parentAccount property. */    
    protected Account parentAccount;

    /** Holds the description property. */    
    protected String description;

    /** Holds the type property. */    
    protected AccountType type;

    /** Holds the balance property. */    
    protected BigDecimal balance;

    /** Holds the entries property. */    
    protected List<Entry> entries;

    /** Holds the taxTableEntries property. */    
    protected Set<TaxTableEntry> taxTableEntries;

    /** No-arg constructor for serialization. */
    public Account() {
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
    public Account withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Accepts a new value for the parentAccount property.
     *
     * @param parentAccount The parentAccount property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Account withParentAccount(Account parentAccount) {
        this.parentAccount = parentAccount;
        return this;
    }

    /**
     * Accepts a new value for the description property.
     *
     * @param description The description property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Account withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Accepts a new value for the type property.
     *
     * @param type The type property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Account withType(AccountType type) {
        this.type = type;
        return this;
    }

    /**
     * Accepts a new value for the balance property.
     *
     * @param balance The balance property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Account withBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    /**
     * Accepts a new value for the entries property.
     *
     * @param entries The entries property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Account withEntries(List<Entry> entries) {
        this.entries = entries;
        return this;
    }

    /**
     * Accepts a new value for the taxTableEntries property.
     *
     * @param taxTableEntries The taxTableEntries property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Account withTaxTableEntries(Set<TaxTableEntry> taxTableEntries) {
        this.taxTableEntries = taxTableEntries;
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
     * Provides the parentAccount property.
     *
     * @return The parentAccount property.
     */
    public Account getParentAccount() {
        return parentAccount;
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
     * Provides the type property.
     *
     * @return The type property.
     */
    public AccountType getType() {
        return type;
    }

    /**
     * Provides the balance property.
     *
     * @return The balance property.
     */
    public BigDecimal getBalance() {
        return balance;
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
     * Provides the taxTableEntries property.
     *
     * @return The taxTableEntries property.
     */
    public Set<TaxTableEntry> getTaxTableEntries() {
        return taxTableEntries;
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
     * Accepts a new value for the parentAccount property.
     *
     * @param parentAccount The parentAccount property.
     */
    public void setParentAccount(Account parentAccount) {
        this.parentAccount = parentAccount;
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
     * Accepts a new value for the type property.
     *
     * @param type The type property.
     */
    public void setType(AccountType type) {
        this.type = type;
    }

    /**
     * Accepts a new value for the balance property.
     *
     * @param balance The balance property.
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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
     * Accepts a new value for the taxTableEntries property.
     *
     * @param taxTableEntries The taxTableEntries property.
     */
    public void setTaxTableEntries(Set<TaxTableEntry> taxTableEntries) {
        this.taxTableEntries = taxTableEntries;
    }

    /**
     * Determines whether an object of this type is equal to another object. To be equal the object being
     * compared to (the comparator) must be an instance of this class and have identical natural key field
     * values to this one.
     *
     * @param o The object to compare to.
     *
     * @return True if the comparator is equal to this, false otherwise.
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (o instanceof Account) {
            Account comp = (Account)o;

            return EqualityHelper.nullSafeEquals(name, comp.name)
                && EqualityHelper.nullSafeEquals(parentAccount, comp.parentAccount);
        } else {
            return false;
        }
    }

    /**
     * Computes a hash code for the component that conforms with its equality method, being based on the same set
     * of fields that are used to compute equality.
     *
     * @return A hash code of the components equality value.
     */
    public int hashCode() {
        return EqualityHelper.nullSafeHashCode(name)
             + EqualityHelper.nullSafeHashCode(parentAccount);
    }

    
}
