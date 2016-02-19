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

import com.thesett.accounts.services.TaxTableService;
import com.thesett.accounts.model.TaxTable;

import java.util.List;

/**
 * Service interface for working with TaxTable
 *
 * @author Generated Code    
 */
@Path("/api/taxTable/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public interface TaxTableClient extends TaxTableService {
    /** {@inheritDoc} */
    @GET
    @Path("/schema")
    @Produces("application/schema+json")    
    JsonSchema schema();

    /** {@inheritDoc} */
    @GET
    List<TaxTable> findAll();

    /** {@inheritDoc} */
    @POST
    @Path("/example")      
    List<TaxTable> findByExample(TaxTable example);

    /** {@inheritDoc} */
    @POST
    TaxTable create(TaxTable taxTable) throws EntityException;

    /** {@inheritDoc} */
    @GET
    @Path("/{taxTableId}")
    TaxTable retrieve(@PathParam("taxTableId") Long id);

    /** {@inheritDoc} */
    @PUT
    @Path("/taxTableId")
    TaxTable update(@PathParam("taxTableId") Long id, TaxTable taxTable) throws EntityException;

    /** {@inheritDoc} */
    @DELETE
    void delete(@PathParam("taxTableId") Long id) throws EntityException;
}
