package com.thesett.accounts.services.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import com.codahale.metrics.annotation.Timed;
import com.strategicgains.hyperexpress.HyperExpress;
import static com.strategicgains.hyperexpress.RelTypes.SELF;
import com.strategicgains.hyperexpress.domain.Resource;

import com.thesett.util.entity.EntityException;
import com.thesett.util.jersey.UnitOfWorkWithDetach;
import com.thesett.util.validation.core.JsonSchemaUtil;
import com.thesett.util.validation.model.JsonSchema;

import com.thesett.accounts.model.Invoice;
import com.thesett.accounts.dao.InvoiceDAO;
import com.thesett.accounts.services.InvoiceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * REST API implementation for working with Invoice
 *
 * @author Generated Code
 */
@Path("/api/invoice/")
@Api("/api/invoice/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class InvoiceResource implements InvoiceService {
    /** The DAO to use for persisting invoice. */
    private final InvoiceDAO invoiceDAO;

    /** Defines the name of the entity this service works with. */
    private static final String ENTITY_NAME = "invoice";

    /**
     * Creates the invoice RESTful service implementation.
     *
     * @param invoiceDAO The DAO to use for persisting invoice.
     */
    public InvoiceResource(InvoiceDAO invoiceDAO) {
        this.invoiceDAO = invoiceDAO;

        initHal();
    }

    /**
     * Configures HyperExpress to produce HAL for this service (experimental and not complete).
     */
    private void initHal() {
        HyperExpress.relationships()
            .forClass(InvoiceResource.class)
            .rel(SELF, "http://localhost:9070/api/invoice/hal");

        HyperExpress.relationships()
            .forClass(InvoiceResource.class)
            .rels("curies", "http://localhost:9070/api/invoice/{rel}")
            .name("invoice")
            .type("application/schema+json")
            .templated(true);

        HyperExpress.relationships()
            .forClass(InvoiceResource.class)
            .rel("invoice:schema", "http://localhost:9070/api/invoice/")
            .type("application/json");
    }

    /** {@inheritDoc} */    
    @GET
    @Path("/hal")
    @Produces("application/hal+json")
    public Resource root() {
        return HyperExpress.createResource(this, "application/hal+json");
    }        

    /** {@inheritDoc} */
    @GET
    @Path("/schema")
    @Produces("application/schema+json")
    public JsonSchema schema() {
        return JsonSchemaUtil.getJsonSchema(Invoice.class);
    }

    /** {@inheritDoc} */
    @GET
    @UnitOfWorkWithDetach
    public List<Invoice> findAll() {
        return invoiceDAO.browse(ENTITY_NAME);
    }

    /** {@inheritDoc} */
    @POST
    @Path("/example")
    @UnitOfWorkWithDetach
    public List<Invoice> findByExample(Invoice example) {
        return invoiceDAO.findByExample(example, ENTITY_NAME);
    }

    /** {@inheritDoc} */
    @POST
    @UnitOfWorkWithDetach
    public Invoice create(Invoice invoice) throws EntityException {
        return invoiceDAO.create(invoice);
    }

    /** {@inheritDoc} */
    @GET
    @Path("/{invoiceId}")
    @Timed
    @UnitOfWorkWithDetach
    public Invoice retrieve(@PathParam("invoiceId") Long id) {
        return invoiceDAO.retrieve(id);
    }

    /** {@inheritDoc} */
    @PUT
    @UnitOfWorkWithDetach
    @Path("/{invoiceId}")
    public Invoice update(@PathParam("invoiceId") Long id, Invoice invoice) throws EntityException {
        return invoiceDAO.update(id, invoice);
    }

    /** {@inheritDoc} */
    @DELETE
    @UnitOfWorkWithDetach
    @Path("/{invoiceId}")    
    public void delete(@PathParam("invoiceId") Long id) throws EntityException {
        invoiceDAO.delete(id);
    }
}
