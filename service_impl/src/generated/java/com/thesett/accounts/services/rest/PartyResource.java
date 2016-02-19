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

import com.thesett.accounts.model.Party;
import com.thesett.accounts.dao.PartyDAO;
import com.thesett.accounts.services.PartyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * REST API implementation for working with Party
 *
 * @author Generated Code
 */
@Path("/api/party/")
@Api("/api/party/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class PartyResource implements PartyService {
    /** The DAO to use for persisting party. */
    private final PartyDAO partyDAO;

    /** Defines the name of the entity this service works with. */
    private static final String ENTITY_NAME = "party";

    /**
     * Creates the party RESTful service implementation.
     *
     * @param partyDAO The DAO to use for persisting party.
     */
    public PartyResource(PartyDAO partyDAO) {
        this.partyDAO = partyDAO;

        initHal();
    }

    /**
     * Configures HyperExpress to produce HAL for this service (experimental and not complete).
     */
    private void initHal() {
        HyperExpress.relationships()
            .forClass(PartyResource.class)
            .rel(SELF, "http://localhost:9070/api/party/hal");

        HyperExpress.relationships()
            .forClass(PartyResource.class)
            .rels("curies", "http://localhost:9070/api/party/{rel}")
            .name("party")
            .type("application/schema+json")
            .templated(true);

        HyperExpress.relationships()
            .forClass(PartyResource.class)
            .rel("party:schema", "http://localhost:9070/api/party/")
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
        return JsonSchemaUtil.getJsonSchema(Party.class);
    }

    /** {@inheritDoc} */
    @GET
    @UnitOfWorkWithDetach
    public List<Party> findAll() {
        return partyDAO.browse(ENTITY_NAME);
    }

    /** {@inheritDoc} */
    @POST
    @Path("/example")
    @UnitOfWorkWithDetach
    public List<Party> findByExample(Party example) {
        return partyDAO.findByExample(example, ENTITY_NAME);
    }

    /** {@inheritDoc} */
    @POST
    @UnitOfWorkWithDetach
    public Party create(Party party) throws EntityException {
        return partyDAO.create(party);
    }

    /** {@inheritDoc} */
    @GET
    @Path("/{partyId}")
    @Timed
    @UnitOfWorkWithDetach
    public Party retrieve(@PathParam("partyId") Long id) {
        return partyDAO.retrieve(id);
    }

    /** {@inheritDoc} */
    @PUT
    @UnitOfWorkWithDetach
    @Path("/{partyId}")
    public Party update(@PathParam("partyId") Long id, Party party) throws EntityException {
        return partyDAO.update(id, party);
    }

    /** {@inheritDoc} */
    @DELETE
    @UnitOfWorkWithDetach
    @Path("/{partyId}")    
    public void delete(@PathParam("partyId") Long id) throws EntityException {
        partyDAO.delete(id);
    }
}
