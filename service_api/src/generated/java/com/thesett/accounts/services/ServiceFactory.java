package com.thesett.accounts.services;

import com.thesett.accounts.services.AccountService;

import com.thesett.accounts.services.EntryService;

import com.thesett.accounts.services.BasicTransactionService;

import com.thesett.accounts.services.PartyService;

import com.thesett.accounts.services.InvoiceService;

import com.thesett.accounts.services.TaxEntryService;

import com.thesett.accounts.services.TaxTableService;

import com.thesett.accounts.services.TaxTableRowService;

import com.thesett.accounts.services.TaxTableEntryService;


/**
 * ServiceFactory describes a factory for creating clients to access the services built on the top-level
 * entities.
 */    
public interface ServiceFactory {

    /**
     * Supplies a proxied instance of the AccountService.
     *
     * @return A proxied instance of the AccountService.
     */
    AccountService getAccountService();

    /**
     * Supplies a proxied instance of the EntryService.
     *
     * @return A proxied instance of the EntryService.
     */
    EntryService getEntryService();

    /**
     * Supplies a proxied instance of the BasicTransactionService.
     *
     * @return A proxied instance of the BasicTransactionService.
     */
    BasicTransactionService getBasicTransactionService();

    /**
     * Supplies a proxied instance of the PartyService.
     *
     * @return A proxied instance of the PartyService.
     */
    PartyService getPartyService();

    /**
     * Supplies a proxied instance of the InvoiceService.
     *
     * @return A proxied instance of the InvoiceService.
     */
    InvoiceService getInvoiceService();

    /**
     * Supplies a proxied instance of the TaxEntryService.
     *
     * @return A proxied instance of the TaxEntryService.
     */
    TaxEntryService getTaxEntryService();

    /**
     * Supplies a proxied instance of the TaxTableService.
     *
     * @return A proxied instance of the TaxTableService.
     */
    TaxTableService getTaxTableService();

    /**
     * Supplies a proxied instance of the TaxTableRowService.
     *
     * @return A proxied instance of the TaxTableRowService.
     */
    TaxTableRowService getTaxTableRowService();

    /**
     * Supplies a proxied instance of the TaxTableEntryService.
     *
     * @return A proxied instance of the TaxTableEntryService.
     */
    TaxTableEntryService getTaxTableEntryService();

}