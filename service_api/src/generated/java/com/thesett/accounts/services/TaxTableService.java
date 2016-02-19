package com.thesett.accounts.services;

import java.util.List;        

import com.strategicgains.hyperexpress.domain.Resource;    
import com.thesett.util.entity.EntityException;
import com.thesett.util.entity.CRUD;
import com.thesett.util.validation.model.JsonSchema;

import com.thesett.accounts.model.TaxTable;

/**
 * Service interface for working with TaxTable
 *
 * @author Generated Code
 */
public interface TaxTableService extends CRUD<TaxTable, Long> {
    /**
     * Provides a root HAL for the service, describing its capabilities.
     *
     * @return The root HAL for the service.
     */
    Resource root();

    /**
     * Provides a json-schema describing the TaxTable data model.
     *
     * @return A json-schema describing the TaxTable data model.
     */
    JsonSchema schema();

    /**
     * Lists all values.
     *
     * @return A list containing all values.
     */
    List<TaxTable> findAll();        

    /**
     * Lists all values that have fields that match the non-null fields in the example.
     *
     * @param example An example to match the fields of.
     *
     * @return A list of all matching values.
     */
    List<TaxTable> findByExample(TaxTable example);

    /** {@inheritDoc} */
    TaxTable create(TaxTable taxTable) throws EntityException;

    /** {@inheritDoc} */
    TaxTable retrieve(Long id);

    /** {@inheritDoc} */
    TaxTable update(Long id, TaxTable taxTable) throws EntityException;

    /** {@inheritDoc} */
    void delete(Long id) throws EntityException;
}
