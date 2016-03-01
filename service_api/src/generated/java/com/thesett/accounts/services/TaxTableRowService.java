package com.thesett.accounts.services;

import java.util.List;        

import com.strategicgains.hyperexpress.domain.Resource;    
import com.thesett.util.entity.EntityException;
import com.thesett.util.entity.CRUD;
import com.thesett.util.validation.model.JsonSchema;

import com.thesett.accounts.model.TaxTableRow;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Service interface for working with TaxTableRow
 *
 * @author Generated Code
 */
@Path("/api/taxTableRow/")        
@Api("/api/taxTableRow/")        
public interface TaxTableRowService extends CRUD<TaxTableRow, Long> {
    /**
     * Provides a root HAL for the service, describing its capabilities.
     *
     * @return The root HAL for the service.
     */
    Resource root();

    /**
     * Provides a json-schema describing the TaxTableRow data model.
     *
     * @return A json-schema describing the TaxTableRow data model.
     */
    JsonSchema schema();

    /**
     * Lists all values.
     *
     * @return A list containing all values.
     */
    List<TaxTableRow> findAll();        

    /**
     * Lists all values that have fields that match the non-null fields in the example.
     *
     * @param example An example to match the fields of.
     *
     * @return A list of all matching values.
     */
    @POST        
    @Path("/example")        
    List<TaxTableRow> findByExample(TaxTableRow example);

    /** {@inheritDoc} */
    TaxTableRow create(TaxTableRow taxTableRow) throws EntityException;

    /** {@inheritDoc} */
    TaxTableRow retrieve(Long id);

    /** {@inheritDoc} */
    TaxTableRow update(Long id, TaxTableRow taxTableRow) throws EntityException;

    /** {@inheritDoc} */
    void delete(Long id) throws EntityException;
}
