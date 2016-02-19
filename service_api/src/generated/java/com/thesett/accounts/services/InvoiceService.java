package com.thesett.accounts.services;

import java.util.List;        

import com.strategicgains.hyperexpress.domain.Resource;    
import com.thesett.util.entity.EntityException;
import com.thesett.util.entity.CRUD;
import com.thesett.util.validation.model.JsonSchema;

import com.thesett.accounts.model.Invoice;

/**
 * Service interface for working with Invoice
 *
 * @author Generated Code
 */
public interface InvoiceService extends CRUD<Invoice, Long> {
    /**
     * Provides a root HAL for the service, describing its capabilities.
     *
     * @return The root HAL for the service.
     */
    Resource root();

    /**
     * Provides a json-schema describing the Invoice data model.
     *
     * @return A json-schema describing the Invoice data model.
     */
    JsonSchema schema();

    /**
     * Lists all values.
     *
     * @return A list containing all values.
     */
    List<Invoice> findAll();        

    /**
     * Lists all values that have fields that match the non-null fields in the example.
     *
     * @param example An example to match the fields of.
     *
     * @return A list of all matching values.
     */
    List<Invoice> findByExample(Invoice example);

    /** {@inheritDoc} */
    Invoice create(Invoice invoice) throws EntityException;

    /** {@inheritDoc} */
    Invoice retrieve(Long id);

    /** {@inheritDoc} */
    Invoice update(Long id, Invoice invoice) throws EntityException;

    /** {@inheritDoc} */
    void delete(Long id) throws EntityException;
}
