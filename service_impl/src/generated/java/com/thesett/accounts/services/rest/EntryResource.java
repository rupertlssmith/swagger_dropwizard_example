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

import com.thesett.accounts.model.Entry;
import com.thesett.accounts.dao.EntryDAO;
import com.thesett.accounts.services.EntryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * REST API implementation for working with Entry
 *
 * @author Generated Code
 */
@Path("/api/entry/")
@Api("/api/entry/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class EntryResource implements EntryService {
    /** The DAO to use for persisting entry. */
    private final EntryDAO entryDAO;

    /** Defines the name of the entity this service works with. */
    private static final String ENTITY_NAME = "entry";

    /**
     * Creates the entry RESTful service implementation.
     *
     * @param entryDAO The DAO to use for persisting entry.
     */
    public EntryResource(EntryDAO entryDAO) {
        this.entryDAO = entryDAO;

        initHal();
    }

    /**
     * Configures HyperExpress to produce HAL for this service (experimental and not complete).
     */
    private void initHal() {
        HyperExpress.relationships()
            .forClass(EntryResource.class)
            .rel(SELF, "http://localhost:9070/api/entry/hal");

        HyperExpress.relationships()
            .forClass(EntryResource.class)
            .rels("curies", "http://localhost:9070/api/entry/{rel}")
            .name("entry")
            .type("application/schema+json")
            .templated(true);

        HyperExpress.relationships()
            .forClass(EntryResource.class)
            .rel("entry:schema", "http://localhost:9070/api/entry/")
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
        return JsonSchemaUtil.getJsonSchema(Entry.class);
    }

    /** {@inheritDoc} */
    @GET
    @UnitOfWorkWithDetach
    public List<Entry> findAll() {
        return entryDAO.browse(ENTITY_NAME);
    }

    /** {@inheritDoc} */
    @POST
    @Path("/example")
    @UnitOfWorkWithDetach
    public List<Entry> findByExample(Entry example) {
        return entryDAO.findByExample(example, ENTITY_NAME);
    }

    /** {@inheritDoc} */
    @POST
    @UnitOfWorkWithDetach
    public Entry create(Entry entry) throws EntityException {
        return entryDAO.create(entry);
    }

    /** {@inheritDoc} */
    @GET
    @Path("/{entryId}")
    @Timed
    @UnitOfWorkWithDetach
    public Entry retrieve(@PathParam("entryId") Long id) {
        return entryDAO.retrieve(id);
    }

    /** {@inheritDoc} */
    @PUT
    @UnitOfWorkWithDetach
    @Path("/{entryId}")
    public Entry update(@PathParam("entryId") Long id, Entry entry) throws EntityException {
        return entryDAO.update(id, entry);
    }

    /** {@inheritDoc} */
    @DELETE
    @UnitOfWorkWithDetach
    @Path("/{entryId}")    
    public void delete(@PathParam("entryId") Long id) throws EntityException {
        entryDAO.delete(id);
    }
}
