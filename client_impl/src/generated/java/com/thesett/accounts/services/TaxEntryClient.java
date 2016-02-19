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

import com.thesett.accounts.services.TaxEntryService;
import com.thesett.accounts.model.TaxEntry;

import java.util.List;

/**
 * Service interface for working with TaxEntry
 *
 * @author Generated Code    
 */
@Path("/api/taxEntry/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public interface TaxEntryClient extends TaxEntryService {
    /** {@inheritDoc} */
    @GET
    @Path("/schema")
    @Produces("application/schema+json")    
    JsonSchema schema();

    /** {@inheritDoc} */
    @GET
    List<TaxEntry> findAll();

    /** {@inheritDoc} */
    @POST
    @Path("/example")      
    List<TaxEntry> findByExample(TaxEntry example);

    /** {@inheritDoc} */
    @POST
    TaxEntry create(TaxEntry taxEntry) throws EntityException;

    /** {@inheritDoc} */
    @GET
    @Path("/{taxEntryId}")
    TaxEntry retrieve(@PathParam("taxEntryId") Long id);

    /** {@inheritDoc} */
    @PUT
    @Path("/taxEntryId")
    TaxEntry update(@PathParam("taxEntryId") Long id, TaxEntry taxEntry) throws EntityException;

    /** {@inheritDoc} */
    @DELETE
    void delete(@PathParam("taxEntryId") Long id) throws EntityException;
}
