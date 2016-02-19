
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
public class TaxSourceType  implements  Serializable {

    /** Holds the taxSourceType property. */    
    protected EnumeratedStringAttribute taxSourceType;

    private static final String INVALID_VALUE = "-=InvalidValue";

    /** No-arg constructor for serialization. */
    public TaxSourceType() {
        // No-arg constructor for serialization.    
    }

    /**
     * The constructor to build the enumeration from a Ref.
     *
     * @param ref The reference data item supplying an id.
     */
    public TaxSourceType(RefDataItem ref) {
        long id = ref.getId();

        if (id != -1) {
            taxSourceType = enumFactory().getAttributeFromId(id);
        } else {
            taxSourceType = enumFactory().createStringAttribute(INVALID_VALUE);
        }
    }

    /**
     * The constructor to build the enumeration from an id.
     *
     * @param id The id.
     */
    public TaxSourceType(long id) {
        if (id != -1) {
            taxSourceType = enumFactory().getAttributeFromId(id);
        } else {
            taxSourceType = enumFactory().createStringAttribute(INVALID_VALUE);
        }
    }

    /**
     * The constructor to build the enumeration from a label or an id.
     *
     * @param value The label.
     */
    public TaxSourceType(String value) {
        TryParseLong valueAsLong = new TryParseLong(value);

        if (valueAsLong.isParsable()) {
            long id = valueAsLong.getLong();

            if (id != -1) {
                taxSourceType = enumFactory().getAttributeFromId(valueAsLong.getLong());
            } else {
                taxSourceType = enumFactory().createStringAttribute(INVALID_VALUE);
            }
        } else {
            taxSourceType = enumFactory().createStringAttribute(value);
        }
    }

    /**
     * The constructor to build the enumeration from an instance.
     *
     * @param taxSourceType The enumeration instance.
     */
    public TaxSourceType(EnumeratedStringAttribute taxSourceType) {
        this.taxSourceType = taxSourceType;
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
        ref.withName(taxSourceType.getStringValue()).setId(taxSourceType.getId());
        return ref;
    }

    /**
     * Supplies the factory for creating instances of the enum.
     *
     * @return The factory for creating instances of the enum.
     */        
    private static EnumeratedStringAttribute.EnumeratedStringAttributeFactory enumFactory() {
        return EnumeratedStringAttribute.getFactoryForClass("taxSourceType");
    }    

    /**
     * Gets the interned id of the enumeration attribute that this bean wraps.
     *
     * @return The interned id of the enumeration attribute that this bean wraps.
     */
    @XmlTransient    
    public Long getId() {
        return taxSourceType.getId();
    }

    /**
     * Sets the id of the enumerated attribute that this bean wraps. This sets the value of the enumerated attribute
     * that this bean wraps, to the one with matching id.
     *
     * @param id The id the enumerated attribute value to use.
     */
    public void setId(Long id) {
        if (id != -1) {
            taxSourceType = enumFactory().getAttributeFromId(id);
        } else {
            taxSourceType = enumFactory().createStringAttribute(INVALID_VALUE);
        }
    }

    
    /**
     * Provides the taxSourceType property.
     *
     * @return The taxSourceType property.
     */
    @XmlTransient
    public EnumeratedStringAttribute getTaxSourceType() {
        return taxSourceType;
    }
    /**
     * Accepts a new value for the taxSourceType property.
     *
     * @param taxSourceType The taxSourceType property.
     */
    public void setTaxSourceType(EnumeratedStringAttribute taxSourceType) {
        this.taxSourceType = taxSourceType;
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

        if (o instanceof TaxSourceType) {
            TaxSourceType comp = (TaxSourceType)o;

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
