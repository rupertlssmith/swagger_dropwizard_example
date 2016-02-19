package com.thesett.accounts.services;

import java.util.List;        

import com.strategicgains.hyperexpress.domain.Resource;    
import com.thesett.util.entity.EntityException;
import com.thesett.util.entity.CRUD;
import com.thesett.util.validation.model.JsonSchema;

import com.thesett.accounts.model.Party;

/**
 * Service interface for working with Party
 *
 * @author Generated Code
 */
public interface PartyService extends CRUD<Party, Long> {
    /**
     * Provides a root HAL for the service, describing its capabilities.
     *
     * @return The root HAL for the service.
     */
    Resource root();

    /**
     * Provides a json-schema describing the Party data model.
     *
     * @return A json-schema describing the Party data model.
     */
    JsonSchema schema();

    /**
     * Lists all values.
     *
     * @return A list containing all values.
     */
    List<Party> findAll();        

    /**
     * Lists all values that have fields that match the non-null fields in the example.
     *
     * @param example An example to match the fields of.
     *
     * @return A list of all matching values.
     */
    List<Party> findByExample(Party example);

    /** {@inheritDoc} */
    Party create(Party party) throws EntityException;

    /** {@inheritDoc} */
    Party retrieve(Long id);

    /** {@inheritDoc} */
    Party update(Long id, Party party) throws EntityException;

    /** {@inheritDoc} */
    void delete(Long id) throws EntityException;
}
