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

import com.thesett.accounts.services.TaxTableRowService;
import com.thesett.accounts.model.TaxTableRow;

import java.util.List;

/**
 * Service interface for working with TaxTableRow
 *
 * @author Generated Code    
 */
@Path("/api/taxTableRow/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public interface TaxTableRowClient extends TaxTableRowService {
    /** {@inheritDoc} */
    @GET
    @Path("/schema")
    @Produces("application/schema+json")    
    JsonSchema schema();

    /** {@inheritDoc} */
    @GET
    List<TaxTableRow> findAll();

    /** {@inheritDoc} */
    @POST
    @Path("/example")      
    List<TaxTableRow> findByExample(TaxTableRow example);

    /** {@inheritDoc} */
    @POST
    TaxTableRow create(TaxTableRow taxTableRow) throws EntityException;

    /** {@inheritDoc} */
    @GET
    @Path("/{taxTableRowId}")
    TaxTableRow retrieve(@PathParam("taxTableRowId") Long id);

    /** {@inheritDoc} */
    @PUT
    @Path("/taxTableRowId")
    TaxTableRow update(@PathParam("taxTableRowId") Long id, TaxTableRow taxTableRow) throws EntityException;

    /** {@inheritDoc} */
    @DELETE
    void delete(@PathParam("taxTableRowId") Long id) throws EntityException;
}
