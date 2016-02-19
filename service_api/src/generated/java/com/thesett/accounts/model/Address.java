
package com.thesett.accounts.model;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include;

    
    

/**
 * Generated bean from catalogue model.    
 *
 * @author Generated Code
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {"componentType"})
@JsonInclude(Include.NON_NULL)
public class Address  implements  Serializable {

    /** Holds the building property. */    
    protected String building;

    /** Holds the street property. */    
    protected String street;

    /** Holds the town property. */    
    protected String town;

    /** Holds the county property. */    
    protected String county;

    /** Holds the country property. */    
    protected String country;

    /** Holds the post_code property. */    
    protected String postCode;

    /** No-arg constructor for serialization. */
    public Address() {
        // No-arg constructor for serialization.
    }

        

    
    /**
     * Accepts a new value for the building property.
     *
     * @param building The building property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Address withBuilding(String building) {
        this.building = building;
        return this;
    }

    /**
     * Accepts a new value for the street property.
     *
     * @param street The street property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Address withStreet(String street) {
        this.street = street;
        return this;
    }

    /**
     * Accepts a new value for the town property.
     *
     * @param town The town property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Address withTown(String town) {
        this.town = town;
        return this;
    }

    /**
     * Accepts a new value for the county property.
     *
     * @param county The county property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Address withCounty(String county) {
        this.county = county;
        return this;
    }

    /**
     * Accepts a new value for the country property.
     *
     * @param country The country property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Address withCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * Accepts a new value for the post_code property.
     *
     * @param postCode The post_code property.
     *
     * @return 'this' (so that fluents can be chained methods).
     */
    public Address withPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }
    /**
     * Provides the building property.
     *
     * @return The building property.
     */
    public String getBuilding() {
        return building;
    }

    /**
     * Provides the street property.
     *
     * @return The street property.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Provides the town property.
     *
     * @return The town property.
     */
    public String getTown() {
        return town;
    }

    /**
     * Provides the county property.
     *
     * @return The county property.
     */
    public String getCounty() {
        return county;
    }

    /**
     * Provides the country property.
     *
     * @return The country property.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Provides the post_code property.
     *
     * @return The post_code property.
     */
    public String getPostCode() {
        return postCode;
    }
    /**
     * Accepts a new value for the building property.
     *
     * @param building The building property.
     */
    public void setBuilding(String building) {
        this.building = building;
    }

    /**
     * Accepts a new value for the street property.
     *
     * @param street The street property.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Accepts a new value for the town property.
     *
     * @param town The town property.
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * Accepts a new value for the county property.
     *
     * @param county The county property.
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * Accepts a new value for the country property.
     *
     * @param country The country property.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Accepts a new value for the post_code property.
     *
     * @param postCode The post_code property.
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    
}
