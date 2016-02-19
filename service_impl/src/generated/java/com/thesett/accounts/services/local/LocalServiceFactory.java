package com.thesett.accounts.services.local;

import com.thesett.accounts.services.ServiceFactory;

import org.hibernate.SessionFactory;
import static com.thesett.util.dao.HibernateSessionAndDetachProxy.proxy;

import com.thesett.accounts.services.AccountService;

import com.thesett.accounts.services.EntryService;

import com.thesett.accounts.services.BasicTransactionService;

import com.thesett.accounts.services.PartyService;

import com.thesett.accounts.services.InvoiceService;

import com.thesett.accounts.services.TaxEntryService;

import com.thesett.accounts.services.TaxTableService;

import com.thesett.accounts.services.TaxTableRowService;

import com.thesett.accounts.services.TaxTableEntryService;


public class LocalServiceFactory implements ServiceFactory {

    private final AccountService accountService;

    private final EntryService entryService;

    private final BasicTransactionService basicTransactionService;

    private final PartyService partyService;

    private final InvoiceService invoiceService;

    private final TaxEntryService taxEntryService;

    private final TaxTableService taxTableService;

    private final TaxTableRowService taxTableRowService;

    private final TaxTableEntryService taxTableEntryService;


    public LocalServiceFactory(SessionFactory sessionFactory, AccountService accountService, EntryService entryService, BasicTransactionService basicTransactionService, PartyService partyService, InvoiceService invoiceService, TaxEntryService taxEntryService, TaxTableService taxTableService, TaxTableRowService taxTableRowService, TaxTableEntryService taxTableEntryService) {
        this.accountService = proxy(accountService, AccountService.class, sessionFactory);

        this.entryService = proxy(entryService, EntryService.class, sessionFactory);

        this.basicTransactionService = proxy(basicTransactionService, BasicTransactionService.class, sessionFactory);

        this.partyService = proxy(partyService, PartyService.class, sessionFactory);

        this.invoiceService = proxy(invoiceService, InvoiceService.class, sessionFactory);

        this.taxEntryService = proxy(taxEntryService, TaxEntryService.class, sessionFactory);

        this.taxTableService = proxy(taxTableService, TaxTableService.class, sessionFactory);

        this.taxTableRowService = proxy(taxTableRowService, TaxTableRowService.class, sessionFactory);

        this.taxTableEntryService = proxy(taxTableEntryService, TaxTableEntryService.class, sessionFactory);

    }

    /** {@inheritDoc} */
    public AccountService getAccountService() {
        return accountService;
    }

    /** {@inheritDoc} */
    public EntryService getEntryService() {
        return entryService;
    }

    /** {@inheritDoc} */
    public BasicTransactionService getBasicTransactionService() {
        return basicTransactionService;
    }

    /** {@inheritDoc} */
    public PartyService getPartyService() {
        return partyService;
    }

    /** {@inheritDoc} */
    public InvoiceService getInvoiceService() {
        return invoiceService;
    }

    /** {@inheritDoc} */
    public TaxEntryService getTaxEntryService() {
        return taxEntryService;
    }

    /** {@inheritDoc} */
    public TaxTableService getTaxTableService() {
        return taxTableService;
    }

    /** {@inheritDoc} */
    public TaxTableRowService getTaxTableRowService() {
        return taxTableRowService;
    }

    /** {@inheritDoc} */
    public TaxTableEntryService getTaxTableEntryService() {
        return taxTableEntryService;
    }

}