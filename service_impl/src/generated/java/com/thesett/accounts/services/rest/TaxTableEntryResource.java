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

import com.thesett.accounts.model.TaxTableEntry;
import com.thesett.accounts.dao.TaxTableEntryDAO;
import com.thesett.accounts.services.TaxTableEntryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * REST API implementation for working with TaxTableEntry
 *
 * @author Generated Code
 */
@Path("/api/taxTableEntry/")
@Api("/api/taxTableEntry/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class TaxTableEntryResource implements TaxTableEntryService {
    /** The DAO to use for persisting taxTableEntry. */
    private final TaxTableEntryDAO taxTableEntryDAO;

    /** Defines the name of the entity this service works with. */
    private static final String ENTITY_NAME = "taxTableEntry";

    /**
     * Creates the taxTableEntry RESTful service implementation.
     *
     * @param taxTableEntryDAO The DAO to use for persisting taxTableEntry.
     */
    public TaxTableEntryResource(TaxTableEntryDAO taxTableEntryDAO) {
        this.taxTableEntryDAO = taxTableEntryDAO;

        initHal();
    }

    /**
     * Configures HyperExpress to produce HAL for this service (experimental and not complete).
     */
    private void initHal() {
        HyperExpress.relationships()
            .forClass(TaxTableEntryResource.class)
            .rel(SELF, "http://localhost:9070/api/taxTableEntry/hal");

        HyperExpress.relationships()
            .forClass(TaxTableEntryResource.class)
            .rels("curies", "http://localhost:9070/api/taxTableEntry/{rel}")
            .name("taxTableEntry")
            .type("application/schema+json")
            .templated(true);

        HyperExpress.relationships()
            .forClass(TaxTableEntryResource.class)
            .rel("taxTableEntry:schema", "http://localhost:9070/api/taxTableEntry/")
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
        return JsonSchemaUtil.getJsonSchema(TaxTableEntry.class);
    }

    /** {@inheritDoc} */
    @GET
    @UnitOfWorkWithDetach
    public List<TaxTableEntry> findAll() {
        return taxTableEntryDAO.browse(ENTITY_NAME);
    }

    /** {@inheritDoc} */
    @POST
    @Path("/example")
    @UnitOfWorkWithDetach
    public List<TaxTableEntry> findByExample(TaxTableEntry example) {
        return taxTableEntryDAO.findByExample(example, ENTITY_NAME);
    }

    /** {@inheritDoc} */
    @POST
    @UnitOfWorkWithDetach
    public TaxTableEntry create(TaxTableEntry taxTableEntry) throws EntityException {
        return taxTableEntryDAO.create(taxTableEntry);
    }

    /** {@inheritDoc} */
    @GET
    @Path("/{taxTableEntryId}")
    @Timed
    @UnitOfWorkWithDetach
    public TaxTableEntry retrieve(@PathParam("taxTableEntryId") Long id) {
        return taxTableEntryDAO.retrieve(id);
    }

    /** {@inheritDoc} */
    @PUT
    @UnitOfWorkWithDetach
    @Path("/{taxTableEntryId}")
    public TaxTableEntry update(@PathParam("taxTableEntryId") Long id, TaxTableEntry taxTableEntry) throws EntityException {
        return taxTableEntryDAO.update(id, taxTableEntry);
    }

    /** {@inheritDoc} */
    @DELETE
    @UnitOfWorkWithDetach
    @Path("/{taxTableEntryId}")    
    public void delete(@PathParam("taxTableEntryId") Long id) throws EntityException {
        taxTableEntryDAO.delete(id);
    }
}
