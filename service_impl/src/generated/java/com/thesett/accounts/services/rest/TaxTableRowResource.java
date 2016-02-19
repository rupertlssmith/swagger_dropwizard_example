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

import com.thesett.accounts.model.TaxTableRow;
import com.thesett.accounts.dao.TaxTableRowDAO;
import com.thesett.accounts.services.TaxTableRowService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * REST API implementation for working with TaxTableRow
 *
 * @author Generated Code
 */
@Path("/api/taxTableRow/")
@Api("/api/taxTableRow/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class TaxTableRowResource implements TaxTableRowService {
    /** The DAO to use for persisting taxTableRow. */
    private final TaxTableRowDAO taxTableRowDAO;

    /** Defines the name of the entity this service works with. */
    private static final String ENTITY_NAME = "taxTableRow";

    /**
     * Creates the taxTableRow RESTful service implementation.
     *
     * @param taxTableRowDAO The DAO to use for persisting taxTableRow.
     */
    public TaxTableRowResource(TaxTableRowDAO taxTableRowDAO) {
        this.taxTableRowDAO = taxTableRowDAO;

        initHal();
    }

    /**
     * Configures HyperExpress to produce HAL for this service (experimental and not complete).
     */
    private void initHal() {
        HyperExpress.relationships()
            .forClass(TaxTableRowResource.class)
            .rel(SELF, "http://localhost:9070/api/taxTableRow/hal");

        HyperExpress.relationships()
            .forClass(TaxTableRowResource.class)
            .rels("curies", "http://localhost:9070/api/taxTableRow/{rel}")
            .name("taxTableRow")
            .type("application/schema+json")
            .templated(true);

        HyperExpress.relationships()
            .forClass(TaxTableRowResource.class)
            .rel("taxTableRow:schema", "http://localhost:9070/api/taxTableRow/")
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
        return JsonSchemaUtil.getJsonSchema(TaxTableRow.class);
    }

    /** {@inheritDoc} */
    @GET
    @UnitOfWorkWithDetach
    public List<TaxTableRow> findAll() {
        return taxTableRowDAO.browse(ENTITY_NAME);
    }

    /** {@inheritDoc} */
    @POST
    @Path("/example")
    @UnitOfWorkWithDetach
    public List<TaxTableRow> findByExample(TaxTableRow example) {
        return taxTableRowDAO.findByExample(example, ENTITY_NAME);
    }

    /** {@inheritDoc} */
    @POST
    @UnitOfWorkWithDetach
    public TaxTableRow create(TaxTableRow taxTableRow) throws EntityException {
        return taxTableRowDAO.create(taxTableRow);
    }

    /** {@inheritDoc} */
    @GET
    @Path("/{taxTableRowId}")
    @Timed
    @UnitOfWorkWithDetach
    public TaxTableRow retrieve(@PathParam("taxTableRowId") Long id) {
        return taxTableRowDAO.retrieve(id);
    }

    /** {@inheritDoc} */
    @PUT
    @UnitOfWorkWithDetach
    @Path("/{taxTableRowId}")
    public TaxTableRow update(@PathParam("taxTableRowId") Long id, TaxTableRow taxTableRow) throws EntityException {
        return taxTableRowDAO.update(id, taxTableRow);
    }

    /** {@inheritDoc} */
    @DELETE
    @UnitOfWorkWithDetach
    @Path("/{taxTableRowId}")    
    public void delete(@PathParam("taxTableRowId") Long id) throws EntityException {
        taxTableRowDAO.delete(id);
    }
}
