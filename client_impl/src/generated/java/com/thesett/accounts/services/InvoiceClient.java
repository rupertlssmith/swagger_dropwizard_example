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

import com.thesett.accounts.services.InvoiceService;
import com.thesett.accounts.model.Invoice;

import java.util.List;

/**
 * Service interface for working with Invoice
 *
 * @author Generated Code    
 */
@Path("/api/invoice/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public interface InvoiceClient extends InvoiceService {
    /** {@inheritDoc} */
    @GET
    @Path("/schema")
    @Produces("application/schema+json")    
    JsonSchema schema();

    /** {@inheritDoc} */
    @GET
    List<Invoice> findAll();

    /** {@inheritDoc} */
    @POST
    @Path("/example")      
    List<Invoice> findByExample(Invoice example);

    /** {@inheritDoc} */
    @POST
    Invoice create(Invoice invoice) throws EntityException;

    /** {@inheritDoc} */
    @GET
    @Path("/{invoiceId}")
    Invoice retrieve(@PathParam("invoiceId") Long id);

    /** {@inheritDoc} */
    @PUT
    @Path("/invoiceId")
    Invoice update(@PathParam("invoiceId") Long id, Invoice invoice) throws EntityException;

    /** {@inheritDoc} */
    @DELETE
    void delete(@PathParam("invoiceId") Long id) throws EntityException;
}
