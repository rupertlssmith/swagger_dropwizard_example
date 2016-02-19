package com.thesett.accounts.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.proxy.WebResourceFactory;

import com.thesett.accounts.services.ServiceFactory;

import com.thesett.util.client.WebExceptionCodeClientProxy;
import com.thesett.util.json.JodaTimeObjectMapperProvider;
import com.thesett.util.model.RefDataItem;    
import com.thesett.util.services.ReferenceDataService;
import com.thesett.aima.attribute.impl.EnumeratedStringAttribute;    
import com.thesett.accounts.services.AccountClient;
import com.thesett.accounts.services.AccountService;
import com.thesett.accounts.services.EntryClient;
import com.thesett.accounts.services.EntryService;
import com.thesett.accounts.services.BasicTransactionClient;
import com.thesett.accounts.services.BasicTransactionService;
import com.thesett.accounts.services.PartyClient;
import com.thesett.accounts.services.PartyService;
import com.thesett.accounts.services.InvoiceClient;
import com.thesett.accounts.services.InvoiceService;
import com.thesett.accounts.services.TaxEntryClient;
import com.thesett.accounts.services.TaxEntryService;
import com.thesett.accounts.services.TaxTableClient;
import com.thesett.accounts.services.TaxTableService;
import com.thesett.accounts.services.TaxTableRowClient;
import com.thesett.accounts.services.TaxTableRowService;
import com.thesett.accounts.services.TaxTableEntryClient;
import com.thesett.accounts.services.TaxTableEntryService;

/**
 * RestJSONClientFactory implements a factory that can supply instances of the service interfaces, as web
 * clients over REST and JSON.
 */
public class ClientServiceFactory implements ServiceFactory {
    /** The base URL to access the services through. */
    private final String baseURL;

    /** A client configuration to use for all services. */
    private final ClientConfig clientConfig;

    /**
     * Creates an instance of the client factory.
     *
     * @param baseURL The base URL to access the api through. This should include the full path to the root of the api
     *                resources, for example, "http://localhost:8080/api".
     */
    public ClientServiceFactory(String baseURL) {
        this.baseURL = baseURL;

        // Set things up to use Jackson JSON.

        clientConfig = new ClientConfig();
        clientConfig.register(JacksonJsonProvider.class);
        clientConfig.register(JodaTimeObjectMapperProvider.class);

        initializeReferenceData();
    }

    /**
     * Creates a proxied client using the supplied interface.
     *
     * @param  resourceInterface The interface to proxy.
     * @param  <T>               The type of the service being proxied.
     *
     * @return A proxied client service.
     */
    public <T> T createClientProxy(Class<T> resourceInterface) {
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget target = client.target(baseURL);

        T clientProxy = WebResourceFactory.newResource(resourceInterface, target);

        return WebExceptionCodeClientProxy.proxy(clientProxy, resourceInterface);
    }

    public ReferenceDataService getReferenceDataService() {
        Class<ReferenceDataService> resourceInterface = ReferenceDataService.class;

        return createClientProxy(resourceInterface);
    }
    /** {@inheritDoc} */
    public AccountService getAccountService() {
        Class<AccountClient> resourceInterface = AccountClient.class;

        return createClientProxy(resourceInterface);
    }    

    /** {@inheritDoc} */
    public EntryService getEntryService() {
        Class<EntryClient> resourceInterface = EntryClient.class;

        return createClientProxy(resourceInterface);
    }    

    /** {@inheritDoc} */
    public BasicTransactionService getBasicTransactionService() {
        Class<BasicTransactionClient> resourceInterface = BasicTransactionClient.class;

        return createClientProxy(resourceInterface);
    }    

    /** {@inheritDoc} */
    public PartyService getPartyService() {
        Class<PartyClient> resourceInterface = PartyClient.class;

        return createClientProxy(resourceInterface);
    }    

    /** {@inheritDoc} */
    public InvoiceService getInvoiceService() {
        Class<InvoiceClient> resourceInterface = InvoiceClient.class;

        return createClientProxy(resourceInterface);
    }    

    /** {@inheritDoc} */
    public TaxEntryService getTaxEntryService() {
        Class<TaxEntryClient> resourceInterface = TaxEntryClient.class;

        return createClientProxy(resourceInterface);
    }    

    /** {@inheritDoc} */
    public TaxTableService getTaxTableService() {
        Class<TaxTableClient> resourceInterface = TaxTableClient.class;

        return createClientProxy(resourceInterface);
    }    

    /** {@inheritDoc} */
    public TaxTableRowService getTaxTableRowService() {
        Class<TaxTableRowClient> resourceInterface = TaxTableRowClient.class;

        return createClientProxy(resourceInterface);
    }    

    /** {@inheritDoc} */
    public TaxTableEntryService getTaxTableEntryService() {
        Class<TaxTableEntryClient> resourceInterface = TaxTableEntryClient.class;

        return createClientProxy(resourceInterface);
    }    

    /** Queries the reference data service to get the ids of all reference data items, and caches them locally. */
    private void initializeReferenceData() {
        ReferenceDataService referenceDataService = getReferenceDataService();

        List<String> allTypes = referenceDataService.findAllTypes();

        for (String type : allTypes) {
            EnumeratedStringAttribute.EnumeratedStringAttributeFactory factoryForClass =
                EnumeratedStringAttribute.getFactoryForClass(type);

            List<RefDataItem> byName = referenceDataService.findByName(type);

            for (RefDataItem item : byName) {
                factoryForClass.createStringAttribute(item.getName()).setId(item.getId());
            }
        }
    }
}