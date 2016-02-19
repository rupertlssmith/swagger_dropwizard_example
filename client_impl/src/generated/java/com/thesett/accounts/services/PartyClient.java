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

import com.thesett.accounts.services.PartyService;
import com.thesett.accounts.model.Party;

import java.util.List;

/**
 * Service interface for working with Party
 *
 * @author Generated Code    
 */
@Path("/api/party/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public interface PartyClient extends PartyService {
    /** {@inheritDoc} */
    @GET
    @Path("/schema")
    @Produces("application/schema+json")    
    JsonSchema schema();

    /** {@inheritDoc} */
    @GET
    List<Party> findAll();

    /** {@inheritDoc} */
    @POST
    @Path("/example")      
    List<Party> findByExample(Party example);

    /** {@inheritDoc} */
    @POST
    Party create(Party party) throws EntityException;

    /** {@inheritDoc} */
    @GET
    @Path("/{partyId}")
    Party retrieve(@PathParam("partyId") Long id);

    /** {@inheritDoc} */
    @PUT
    @Path("/partyId")
    Party update(@PathParam("partyId") Long id, Party party) throws EntityException;

    /** {@inheritDoc} */
    @DELETE
    void delete(@PathParam("partyId") Long id) throws EntityException;
}
