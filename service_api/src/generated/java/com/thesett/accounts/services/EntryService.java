package com.thesett.accounts.services;

import java.util.List;        

import com.strategicgains.hyperexpress.domain.Resource;    
import com.thesett.util.entity.EntityException;
import com.thesett.util.entity.CRUD;
import com.thesett.util.validation.model.JsonSchema;

import com.thesett.accounts.model.Entry;

/**
 * Service interface for working with Entry
 *
 * @author Generated Code
 */
public interface EntryService extends CRUD<Entry, Long> {
    /**
     * Provides a root HAL for the service, describing its capabilities.
     *
     * @return The root HAL for the service.
     */
    Resource root();

    /**
     * Provides a json-schema describing the Entry data model.
     *
     * @return A json-schema describing the Entry data model.
     */
    JsonSchema schema();

    /**
     * Lists all values.
     *
     * @return A list containing all values.
     */
    List<Entry> findAll();        

    /**
     * Lists all values that have fields that match the non-null fields in the example.
     *
     * @param example An example to match the fields of.
     *
     * @return A list of all matching values.
     */
    List<Entry> findByExample(Entry example);

    /** {@inheritDoc} */
    Entry create(Entry entry) throws EntityException;

    /** {@inheritDoc} */
    Entry retrieve(Long id);

    /** {@inheritDoc} */
    Entry update(Long id, Entry entry) throws EntityException;

    /** {@inheritDoc} */
    void delete(Long id) throws EntityException;
}
