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

import com.thesett.accounts.model.TaxEntry;
import com.thesett.accounts.dao.TaxEntryDAO;
import com.thesett.accounts.services.TaxEntryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * REST API implementation for working with TaxEntry
 *
 * @author Generated Code
 */
@Path("/api/taxEntry/")
@Api("/api/taxEntry/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class TaxEntryResource implements TaxEntryService {
    /** The DAO to use for persisting taxEntry. */
    private final TaxEntryDAO taxEntryDAO;

    /** Defines the name of the entity this service works with. */
    private static final String ENTITY_NAME = "taxEntry";

    /**
     * Creates the taxEntry RESTful service implementation.
     *
     * @param taxEntryDAO The DAO to use for persisting taxEntry.
     */
    public TaxEntryResource(TaxEntryDAO taxEntryDAO) {
        this.taxEntryDAO = taxEntryDAO;

        initHal();
    }

    /**
     * Configures HyperExpress to produce HAL for this service (experimental and not complete).
     */
    private void initHal() {
        HyperExpress.relationships()
            .forClass(TaxEntryResource.class)
            .rel(SELF, "http://localhost:9070/api/taxEntry/hal");

        HyperExpress.relationships()
            .forClass(TaxEntryResource.class)
            .rels("curies", "http://localhost:9070/api/taxEntry/{rel}")
            .name("taxEntry")
            .type("application/schema+json")
            .templated(true);

        HyperExpress.relationships()
            .forClass(TaxEntryResource.class)
            .rel("taxEntry:schema", "http://localhost:9070/api/taxEntry/")
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
        return JsonSchemaUtil.getJsonSchema(TaxEntry.class);
    }

    /** {@inheritDoc} */
    @GET
    @UnitOfWorkWithDetach
    public List<TaxEntry> findAll() {
        return taxEntryDAO.browse(ENTITY_NAME);
    }

    /** {@inheritDoc} */
    @POST
    @Path("/example")
    @UnitOfWorkWithDetach
    public List<TaxEntry> findByExample(TaxEntry example) {
        return taxEntryDAO.findByExample(example, ENTITY_NAME);
    }

    /** {@inheritDoc} */
    @POST
    @UnitOfWorkWithDetach
    public TaxEntry create(TaxEntry taxEntry) throws EntityException {
        return taxEntryDAO.create(taxEntry);
    }

    /** {@inheritDoc} */
    @GET
    @Path("/{taxEntryId}")
    @Timed
    @UnitOfWorkWithDetach
    public TaxEntry retrieve(@PathParam("taxEntryId") Long id) {
        return taxEntryDAO.retrieve(id);
    }

    /** {@inheritDoc} */
    @PUT
    @UnitOfWorkWithDetach
    @Path("/{taxEntryId}")
    public TaxEntry update(@PathParam("taxEntryId") Long id, TaxEntry taxEntry) throws EntityException {
        return taxEntryDAO.update(id, taxEntry);
    }

    /** {@inheritDoc} */
    @DELETE
    @UnitOfWorkWithDetach
    @Path("/{taxEntryId}")    
    public void delete(@PathParam("taxEntryId") Long id) throws EntityException {
        taxEntryDAO.delete(id);
    }
}
