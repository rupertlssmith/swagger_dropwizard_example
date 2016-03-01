package com.thesett.accounts.services;

import java.util.List;        

import com.strategicgains.hyperexpress.domain.Resource;    
import com.thesett.util.entity.EntityException;
import com.thesett.util.entity.CRUD;
import com.thesett.util.validation.model.JsonSchema;

import com.thesett.accounts.model.TaxTableEntry;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Service interface for working with TaxTableEntry
 *
 * @author Generated Code
 */
@Path("/api/taxTableEntry/")        
@Api("/api/taxTableEntry/")        
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
    @POST        
    @Path("/example")        
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
