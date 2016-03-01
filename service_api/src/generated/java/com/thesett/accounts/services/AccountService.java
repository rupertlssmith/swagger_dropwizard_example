package com.thesett.accounts.services;

import java.util.List;        

import com.strategicgains.hyperexpress.domain.Resource;    
import com.thesett.util.entity.EntityException;
import com.thesett.util.entity.CRUD;
import com.thesett.util.validation.model.JsonSchema;

import com.thesett.accounts.model.Account;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Service interface for working with Account
 *
 * @author Generated Code
 */
@Path("/api/account/")        
@Api("/api/account/")        
public interface AccountService extends CRUD<Account, Long> {
    /**
     * Provides a root HAL for the service, describing its capabilities.
     *
     * @return The root HAL for the service.
     */
    Resource root();

    /**
     * Provides a json-schema describing the Account data model.
     *
     * @return A json-schema describing the Account data model.
     */
    JsonSchema schema();

    /**
     * Lists all values.
     *
     * @return A list containing all values.
     */
    List<Account> findAll();        

    /**
     * Lists all values that have fields that match the non-null fields in the example.
     *
     * @param example An example to match the fields of.
     *
     * @return A list of all matching values.
     */
    @POST        
    @Path("/example")        
    List<Account> findByExample(Account example);

    /** {@inheritDoc} */
    Account create(Account account) throws EntityException;

    /** {@inheritDoc} */
    Account retrieve(Long id);

    /** {@inheritDoc} */
    Account update(Long id, Account account) throws EntityException;

    /** {@inheritDoc} */
    void delete(Long id) throws EntityException;
}
