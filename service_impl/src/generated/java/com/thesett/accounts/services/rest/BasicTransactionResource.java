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

import com.thesett.accounts.model.BasicTransaction;
import com.thesett.accounts.dao.BasicTransactionDAO;
import com.thesett.accounts.services.BasicTransactionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * REST API implementation for working with BasicTransaction
 *
 * @author Generated Code
 */
@Path("/api/basicTransaction/")
@Api("/api/basicTransaction/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class BasicTransactionResource implements BasicTransactionService {
    /** The DAO to use for persisting basicTransaction. */
    private final BasicTransactionDAO basicTransactionDAO;

    /** Defines the name of the entity this service works with. */
    private static final String ENTITY_NAME = "basicTransaction";

    /**
     * Creates the basicTransaction RESTful service implementation.
     *
     * @param basicTransactionDAO The DAO to use for persisting basicTransaction.
     */
    public BasicTransactionResource(BasicTransactionDAO basicTransactionDAO) {
        this.basicTransactionDAO = basicTransactionDAO;

        initHal();
    }

    /**
     * Configures HyperExpress to produce HAL for this service (experimental and not complete).
     */
    private void initHal() {
        HyperExpress.relationships()
            .forClass(BasicTransactionResource.class)
            .rel(SELF, "http://localhost:9070/api/basicTransaction/hal");

        HyperExpress.relationships()
            .forClass(BasicTransactionResource.class)
            .rels("curies", "http://localhost:9070/api/basicTransaction/{rel}")
            .name("basicTransaction")
            .type("application/schema+json")
            .templated(true);

        HyperExpress.relationships()
            .forClass(BasicTransactionResource.class)
            .rel("basicTransaction:schema", "http://localhost:9070/api/basicTransaction/")
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
        return JsonSchemaUtil.getJsonSchema(BasicTransaction.class);
    }

    /** {@inheritDoc} */
    @GET
    @UnitOfWorkWithDetach
    public List<BasicTransaction> findAll() {
        return basicTransactionDAO.browse(ENTITY_NAME);
    }

    /** {@inheritDoc} */
    @POST
    @Path("/example")
    @UnitOfWorkWithDetach
    public List<BasicTransaction> findByExample(BasicTransaction example) {
        return basicTransactionDAO.findByExample(example, ENTITY_NAME);
    }

    /** {@inheritDoc} */
    @POST
    @UnitOfWorkWithDetach
    public BasicTransaction create(BasicTransaction basicTransaction) throws EntityException {
        return basicTransactionDAO.create(basicTransaction);
    }

    /** {@inheritDoc} */
    @GET
    @Path("/{basicTransactionId}")
    @Timed
    @UnitOfWorkWithDetach
    public BasicTransaction retrieve(@PathParam("basicTransactionId") Long id) {
        return basicTransactionDAO.retrieve(id);
    }

    /** {@inheritDoc} */
    @PUT
    @UnitOfWorkWithDetach
    @Path("/{basicTransactionId}")
    public BasicTransaction update(@PathParam("basicTransactionId") Long id, BasicTransaction basicTransaction) throws EntityException {
        return basicTransactionDAO.update(id, basicTransaction);
    }

    /** {@inheritDoc} */
    @DELETE
    @UnitOfWorkWithDetach
    @Path("/{basicTransactionId}")    
    public void delete(@PathParam("basicTransactionId") Long id) throws EntityException {
        basicTransactionDAO.delete(id);
    }
}
