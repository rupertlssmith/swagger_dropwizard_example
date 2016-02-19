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

import com.thesett.accounts.model.TaxTable;
import com.thesett.accounts.dao.TaxTableDAO;
import com.thesett.accounts.services.TaxTableService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * REST API implementation for working with TaxTable
 *
 * @author Generated Code
 */
@Path("/api/taxTable/")
@Api("/api/taxTable/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class TaxTableResource implements TaxTableService {
    /** The DAO to use for persisting taxTable. */
    private final TaxTableDAO taxTableDAO;

    /** Defines the name of the entity this service works with. */
    private static final String ENTITY_NAME = "taxTable";

    /**
     * Creates the taxTable RESTful service implementation.
     *
     * @param taxTableDAO The DAO to use for persisting taxTable.
     */
    public TaxTableResource(TaxTableDAO taxTableDAO) {
        this.taxTableDAO = taxTableDAO;

        initHal();
    }

    /**
     * Configures HyperExpress to produce HAL for this service (experimental and not complete).
     */
    private void initHal() {
        HyperExpress.relationships()
            .forClass(TaxTableResource.class)
            .rel(SELF, "http://localhost:9070/api/taxTable/hal");

        HyperExpress.relationships()
            .forClass(TaxTableResource.class)
            .rels("curies", "http://localhost:9070/api/taxTable/{rel}")
            .name("taxTable")
            .type("application/schema+json")
            .templated(true);

        HyperExpress.relationships()
            .forClass(TaxTableResource.class)
            .rel("taxTable:schema", "http://localhost:9070/api/taxTable/")
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
        return JsonSchemaUtil.getJsonSchema(TaxTable.class);
    }

    /** {@inheritDoc} */
    @GET
    @UnitOfWorkWithDetach
    public List<TaxTable> findAll() {
        return taxTableDAO.browse(ENTITY_NAME);
    }

    /** {@inheritDoc} */
    @POST
    @Path("/example")
    @UnitOfWorkWithDetach
    public List<TaxTable> findByExample(TaxTable example) {
        return taxTableDAO.findByExample(example, ENTITY_NAME);
    }

    /** {@inheritDoc} */
    @POST
    @UnitOfWorkWithDetach
    public TaxTable create(TaxTable taxTable) throws EntityException {
        return taxTableDAO.create(taxTable);
    }

    /** {@inheritDoc} */
    @GET
    @Path("/{taxTableId}")
    @Timed
    @UnitOfWorkWithDetach
    public TaxTable retrieve(@PathParam("taxTableId") Long id) {
        return taxTableDAO.retrieve(id);
    }

    /** {@inheritDoc} */
    @PUT
    @UnitOfWorkWithDetach
    @Path("/{taxTableId}")
    public TaxTable update(@PathParam("taxTableId") Long id, TaxTable taxTable) throws EntityException {
        return taxTableDAO.update(id, taxTable);
    }

    /** {@inheritDoc} */
    @DELETE
    @UnitOfWorkWithDetach
    @Path("/{taxTableId}")    
    public void delete(@PathParam("taxTableId") Long id) throws EntityException {
        taxTableDAO.delete(id);
    }
}
