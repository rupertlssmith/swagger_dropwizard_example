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

import com.thesett.accounts.services.TaxTableEntryService;
import com.thesett.accounts.model.TaxTableEntry;

import java.util.List;

/**
 * Service interface for working with TaxTableEntry
 *
 * @author Generated Code    
 */
@Path("/api/taxTableEntry/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public interface TaxTableEntryClient extends TaxTableEntryService {
    /** {@inheritDoc} */
    @GET
    @Path("/schema")
    @Produces("application/schema+json")    
    JsonSchema schema();

    /** {@inheritDoc} */
    @GET
    List<TaxTableEntry> findAll();

    /** {@inheritDoc} */
    @POST
    @Path("/example")      
    List<TaxTableEntry> findByExample(TaxTableEntry example);

    /** {@inheritDoc} */
    @POST
    TaxTableEntry create(TaxTableEntry taxTableEntry) throws EntityException;

    /** {@inheritDoc} */
    @GET
    @Path("/{taxTableEntryId}")
    TaxTableEntry retrieve(@PathParam("taxTableEntryId") Long id);

    /** {@inheritDoc} */
    @PUT
    @Path("/taxTableEntryId")
    TaxTableEntry update(@PathParam("taxTableEntryId") Long id, TaxTableEntry taxTableEntry) throws EntityException;

    /** {@inheritDoc} */
    @DELETE
    void delete(@PathParam("taxTableEntryId") Long id) throws EntityException;
}
