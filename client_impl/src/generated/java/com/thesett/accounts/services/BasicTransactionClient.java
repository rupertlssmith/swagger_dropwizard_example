package com.thesett.accounts.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.thesett.util.entity.EntityException;
import com.thesett.util.validation.model.JsonSchema;

import com.thesett.accounts.services.BasicTransactionService;
import com.thesett.accounts.model.BasicTransaction;

import java.util.List;

/**
 * Service interface for working with BasicTransaction
 *
 * @author Generated Code    
 */
@Path("/api/basicTransaction/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public interface BasicTransactionClient extends BasicTransactionService {
    /** {@inheritDoc} */
    @GET
    @Path("/schema")
    @Produces("application/schema+json")    
    JsonSchema schema();

    /** {@inheritDoc} */
    @GET
    List<BasicTransaction> findAll();

    /** {@inheritDoc} */
    @POST
    @Path("/example")      
    List<BasicTransaction> findByExample(BasicTransaction example);

    /** {@inheritDoc} */
    @POST
    BasicTransaction create(BasicTransaction basicTransaction) throws EntityException;

    /** {@inheritDoc} */
    @GET
    @Path("/{basicTransactionId}")
    BasicTransaction retrieve(@PathParam("basicTransactionId") Long id);

    /** {@inheritDoc} */
    @PUT
    @Path("/basicTransactionId")
    BasicTransaction update(@PathParam("basicTransactionId") Long id, BasicTransaction basicTransaction) throws EntityException;

    /** {@inheritDoc} */
    @DELETE
    void delete(@PathParam("basicTransactionId") Long id) throws EntityException;
}
