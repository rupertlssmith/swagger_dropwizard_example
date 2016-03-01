package com.thesett.accounts.services;

import java.util.List;        

import com.strategicgains.hyperexpress.domain.Resource;    
import com.thesett.util.entity.EntityException;
import com.thesett.util.entity.CRUD;
import com.thesett.util.validation.model.JsonSchema;

import com.thesett.accounts.model.BasicTransaction;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Service interface for working with BasicTransaction
 *
 * @author Generated Code
 */
@Path("/api/basicTransaction/")        
@Api("/api/basicTransaction/")        
public interface BasicTransactionService extends CRUD<BasicTransaction, Long> {
    /**
     * Provides a root HAL for the service, describing its capabilities.
     *
     * @return The root HAL for the service.
     */
    Resource root();

    /**
     * Provides a json-schema describing the BasicTransaction data model.
     *
     * @return A json-schema describing the BasicTransaction data model.
     */
    JsonSchema schema();

    /**
     * Lists all values.
     *
     * @return A list containing all values.
     */
    List<BasicTransaction> findAll();        

    /**
     * Lists all values that have fields that match the non-null fields in the example.
     *
     * @param example An example to match the fields of.
     *
     * @return A list of all matching values.
     */
    @POST        
    @Path("/example")        
    List<BasicTransaction> findByExample(BasicTransaction example);

    /** {@inheritDoc} */
    BasicTransaction create(BasicTransaction basicTransaction) throws EntityException;

    /** {@inheritDoc} */
    BasicTransaction retrieve(Long id);

    /** {@inheritDoc} */
    BasicTransaction update(Long id, BasicTransaction basicTransaction) throws EntityException;

    /** {@inheritDoc} */
    void delete(Long id) throws EntityException;
}
