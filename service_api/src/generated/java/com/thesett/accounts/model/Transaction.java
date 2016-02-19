
package com.thesett.accounts.model;

import java.util.List;
import org.joda.time.LocalDate;


/**
 * Generated bean interface from catalogue model.
 *
 * @author Generated Code
 */
public interface Transaction {
    /**
     * Provides the description property.
     *
     * @return The description property.
     */
    String getDescription();

    /**
     * Accepts a new value for the description property.
     *
     * @param description The description property.
     */
    void setDescription(String description);

    /**
     * Provides the entries property.
     *
     * @return The entries property.
     */
    List<Entry> getEntries();

    /**
     * Accepts a new value for the entries property.
     *
     * @param entries The entries property.
     */
    void setEntries(List<Entry> entries);

    /**
     * Provides the date property.
     *
     * @return The date property.
     */
    LocalDate getDate();

    /**
     * Accepts a new value for the date property.
     *
     * @param date The date property.
     */
    void setDate(LocalDate date);
}
