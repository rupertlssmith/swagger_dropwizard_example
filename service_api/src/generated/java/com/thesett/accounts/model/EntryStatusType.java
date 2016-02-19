
package com.thesett.accounts.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonValue;

import com.thesett.util.model.RefDataItem;
import com.thesett.util.parsing.TryParseLong;

import com.thesett.aima.attribute.impl.EnumeratedStringAttribute;

import com.thesett.util.equality.EqualityHelper;
    
    

/**
 * Generated bean from catalogue model.    
 *
 * @author Generated Code
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)    
public class EntryStatusType  implements  Serializable {

    /** Holds the entryStatusType property. */    
    protected EnumeratedStringAttribute entryStatusType;

    private static final String INVALID_VALUE = "-=InvalidValue";

    /** No-arg constructor for serialization. */
    public EntryStatusType() {
        // No-arg constructor for serialization.    
    }

    /**
     * The constructor to build the enumeration from a Ref.
     *
     * @param ref The reference data item supplying an id.
     */
    public EntryStatusType(RefDataItem ref) {
        long id = ref.getId();

        if (id != -1) {
            entryStatusType = enumFactory().getAttributeFromId(id);
        } else {
            entryStatusType = enumFactory().createStringAttribute(INVALID_VALUE);
        }
    }

    /**
     * The constructor to build the enumeration from an id.
     *
     * @param id The id.
     */
    public EntryStatusType(long id) {
        if (id != -1) {
            entryStatusType = enumFactory().getAttributeFromId(id);
        } else {
            entryStatusType = enumFactory().createStringAttribute(INVALID_VALUE);
        }
    }

    /**
     * The constructor to build the enumeration from a label or an id.
     *
     * @param value The label.
     */
    public EntryStatusType(String value) {
        TryParseLong valueAsLong = new TryParseLong(value);

        if (valueAsLong.isParsable()) {
            long id = valueAsLong.getLong();

            if (id != -1) {
                entryStatusType = enumFactory().getAttributeFromId(valueAsLong.getLong());
            } else {
                entryStatusType = enumFactory().createStringAttribute(INVALID_VALUE);
            }
        } else {
            entryStatusType = enumFactory().createStringAttribute(value);
        }
    }

    /**
     * The constructor to build the enumeration from an instance.
     *
     * @param entryStatusType The enumeration instance.
     */
    public EntryStatusType(EnumeratedStringAttribute entryStatusType) {
        this.entryStatusType = entryStatusType;
    }

    /**
     * Produces a string representation for JSON serialization.
     *
     * @return A string representation for JSON serialization.
     */
    @JsonValue
    @XmlValue
    public RefDataItem getAsJson() {
        RefDataItem ref = new RefDataItem();
        ref.withName(entryStatusType.getStringValue()).setId(entryStatusType.getId());
        return ref;
    }

    /**
     * Supplies the factory for creating instances of the enum.
     *
     * @return The factory for creating instances of the enum.
     */        
    private static EnumeratedStringAttribute.EnumeratedStringAttributeFactory enumFactory() {
        return EnumeratedStringAttribute.getFactoryForClass("entryStatusType");
    }    

    /**
     * Gets the interned id of the enumeration attribute that this bean wraps.
     *
     * @return The interned id of the enumeration attribute that this bean wraps.
     */
    @XmlTransient    
    public Long getId() {
        return entryStatusType.getId();
    }

    /**
     * Sets the id of the enumerated attribute that this bean wraps. This sets the value of the enumerated attribute
     * that this bean wraps, to the one with matching id.
     *
     * @param id The id the enumerated attribute value to use.
     */
    public void setId(Long id) {
        if (id != -1) {
            entryStatusType = enumFactory().getAttributeFromId(id);
        } else {
            entryStatusType = enumFactory().createStringAttribute(INVALID_VALUE);
        }
    }

    
    /**
     * Provides the entryStatusType property.
     *
     * @return The entryStatusType property.
     */
    @XmlTransient
    public EnumeratedStringAttribute getEntryStatusType() {
        return entryStatusType;
    }
    /**
     * Accepts a new value for the entryStatusType property.
     *
     * @param entryStatusType The entryStatusType property.
     */
    public void setEntryStatusType(EnumeratedStringAttribute entryStatusType) {
        this.entryStatusType = entryStatusType;
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

        if (o instanceof EntryStatusType) {
            EntryStatusType comp = (EntryStatusType)o;

            return EqualityHelper.nullSafeEquals(getId(), comp.getId());
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
        return EqualityHelper.nullSafeHashCode(getId());
    }
    
}
