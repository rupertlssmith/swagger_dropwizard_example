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

import com.thesett.accounts.services.EntryService;
import com.thesett.accounts.model.Entry;

import java.util.List;

/**
 * Service interface for working with Entry
 *
 * @author Generated Code    
 */
@Path("/api/entry/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public interface EntryClient extends EntryService {
    /** {@inheritDoc} */
    @GET
    @Path("/schema")
    @Produces("application/schema+json")    
    JsonSchema schema();

    /** {@inheritDoc} */
    @GET
    List<Entry> findAll();

    /** {@inheritDoc} */
    @POST
    @Path("/example")      
    List<Entry> findByExample(Entry example);

    /** {@inheritDoc} */
    @POST
    Entry create(Entry entry) throws EntityException;

    /** {@inheritDoc} */
    @GET
    @Path("/{entryId}")
    Entry retrieve(@PathParam("entryId") Long id);

    /** {@inheritDoc} */
    @PUT
    @Path("/entryId")
    Entry update(@PathParam("entryId") Long id, Entry entry) throws EntityException;

    /** {@inheritDoc} */
    @DELETE
    void delete(@PathParam("entryId") Long id) throws EntityException;
}
