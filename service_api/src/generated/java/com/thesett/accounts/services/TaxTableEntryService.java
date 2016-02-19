package com.thesett.accounts.services;

import java.util.List;        

import com.strategicgains.hyperexpress.domain.Resource;    
import com.thesett.util.entity.EntityException;
import com.thesett.util.entity.CRUD;
import com.thesett.util.validation.model.JsonSchema;

import com.thesett.accounts.model.TaxTableEntry;

/**
 * Service interface for working with TaxTableEntry
 *
 * @author Generated Code
 */
public interface TaxTableEntryService extends CRUD<TaxTableEntry, Long> {
    /**
     * Provides a root HAL for the service, describing its capabilities.
     *
     * @return The root HAL for the service.
     */
    Resource root();

    /**
     * Provides a json-schema describing the TaxTableEntry data model.
     *
     * @return A json-schema describing the TaxTableEntry data model.
     */
    JsonSchema schema();

    /**
     * Lists all values.
     *
     * @return A list containing all values.
     */
    List<TaxTableEntry> findAll();        

    /**
     * Lists all values that have fields that match the non-null fields in the example.
     *
     * @param example An example to match the fields of.
     *
     * @return A list of all matching values.
     */
    List<TaxTableEntry> findByExample(TaxTableEntry example);

    /** {@inheritDoc} */
    TaxTableEntry create(TaxTableEntry taxTableEntry) throws EntityException;

    /** {@inheritDoc} */
    TaxTableEntry retrieve(Long id);

    /** {@inheritDoc} */
    TaxTableEntry update(Long id, TaxTableEntry taxTableEntry) throws EntityException;

    /** {@inheritDoc} */
    void delete(Long id) throws EntityException;
}
