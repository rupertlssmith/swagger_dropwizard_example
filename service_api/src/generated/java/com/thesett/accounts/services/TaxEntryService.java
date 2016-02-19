package com.thesett.accounts.services;

import java.util.List;        

import com.strategicgains.hyperexpress.domain.Resource;    
import com.thesett.util.entity.EntityException;
import com.thesett.util.entity.CRUD;
import com.thesett.util.validation.model.JsonSchema;

import com.thesett.accounts.model.TaxEntry;

/**
 * Service interface for working with TaxEntry
 *
 * @author Generated Code
 */
public interface TaxEntryService extends CRUD<TaxEntry, Long> {
    /**
     * Provides a root HAL for the service, describing its capabilities.
     *
     * @return The root HAL for the service.
     */
    Resource root();

    /**
     * Provides a json-schema describing the TaxEntry data model.
     *
     * @return A json-schema describing the TaxEntry data model.
     */
    JsonSchema schema();

    /**
     * Lists all values.
     *
     * @return A list containing all values.
     */
    List<TaxEntry> findAll();        

    /**
     * Lists all values that have fields that match the non-null fields in the example.
     *
     * @param example An example to match the fields of.
     *
     * @return A list of all matching values.
     */
    List<TaxEntry> findByExample(TaxEntry example);

    /** {@inheritDoc} */
    TaxEntry create(TaxEntry taxEntry) throws EntityException;

    /** {@inheritDoc} */
    TaxEntry retrieve(Long id);

    /** {@inheritDoc} */
    TaxEntry update(Long id, TaxEntry taxEntry) throws EntityException;

    /** {@inheritDoc} */
    void delete(Long id) throws EntityException;
}
