package com.thesett.accounts.top;

import java.io.InputStream;
import java.text.ParseException;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;                
import com.fasterxml.jackson.databind.SerializationFeature;
import com.strategicgains.hyperexpress.HyperExpress;
import com.strategicgains.hyperexpress.domain.hal.HalResourceFactory;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.thesett.util.commands.refdata.RefDataLoadCommand;
import com.thesett.util.commands.dropviews.DropViewsCommand;
import com.thesett.util.config.hibernate.HibernateXmlBundle;
import com.thesett.util.config.hyperexpress.HalResourceModule;
import com.thesett.util.config.refdata.RefDataSetupBundle;
import com.thesett.util.config.validation.BeanValidationBundle;
import com.thesett.util.errors.StandardExceptionMapper;
import com.thesett.util.json.JodaTimeModule;
import com.thesett.util.services.rest.ReferenceDataResource;

import com.thesett.accounts.config.AppConfiguration;    
import com.thesett.accounts.services.ServiceFactory;
import com.thesett.accounts.services.local.LocalServiceFactory;
import com.thesett.accounts.dao.AccountDAO;
import com.thesett.accounts.dao.AccountDAOImpl;
import com.thesett.accounts.services.rest.AccountResource;    
import com.thesett.accounts.dao.EntryDAO;
import com.thesett.accounts.dao.EntryDAOImpl;
import com.thesett.accounts.services.rest.EntryResource;    
import com.thesett.accounts.dao.BasicTransactionDAO;
import com.thesett.accounts.dao.BasicTransactionDAOImpl;
import com.thesett.accounts.services.rest.BasicTransactionResource;    
import com.thesett.accounts.dao.PartyDAO;
import com.thesett.accounts.dao.PartyDAOImpl;
import com.thesett.accounts.services.rest.PartyResource;    
import com.thesett.accounts.dao.InvoiceDAO;
import com.thesett.accounts.dao.InvoiceDAOImpl;
import com.thesett.accounts.services.rest.InvoiceResource;    
import com.thesett.accounts.dao.TaxEntryDAO;
import com.thesett.accounts.dao.TaxEntryDAOImpl;
import com.thesett.accounts.services.rest.TaxEntryResource;    
import com.thesett.accounts.dao.TaxTableDAO;
import com.thesett.accounts.dao.TaxTableDAOImpl;
import com.thesett.accounts.services.rest.TaxTableResource;    
import com.thesett.accounts.dao.TaxTableRowDAO;
import com.thesett.accounts.dao.TaxTableRowDAOImpl;
import com.thesett.accounts.services.rest.TaxTableRowResource;    
import com.thesett.accounts.dao.TaxTableEntryDAO;
import com.thesett.accounts.dao.TaxTableEntryDAOImpl;
import com.thesett.accounts.services.rest.TaxTableEntryResource;    

public class Main extends Application<AppConfiguration> {
    /** Latch used to ensure hyper express is only initialized once. */
    private static boolean hyperExpressInitialized;

    /** Holds the command for setting up reference data in the database. */
    private static RefDataLoadCommand<AppConfiguration> refDataLoadCommand =
        new RefDataLoadCommand<AppConfiguration>() {
            /** {@inheritDoc} */
            public String getRefdataPackage(AppConfiguration configuration) {
                return configuration.getRefdata();
            }

            /** {@inheritDoc} */
            public DataSourceFactory getDataSourceFactory(AppConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        };

    /** Holds the command for clearing all database views - to compensate for bug in Liquibase. */
    private static DropViewsCommand<AppConfiguration> dropViewsCommand =
            new DropViewsCommand<AppConfiguration>() {
                /** {@inheritDoc} */
                public DataSourceFactory getDataSourceFactory(AppConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    /** The hibernate resource bundle. */
    private final HibernateXmlBundle<AppConfiguration> hibernateXmlBundle =
        new HibernateXmlBundle<AppConfiguration>("accounts-model.hbm.xml") {
            /** {@inheritDoc} */
            public DataSourceFactory getDataSourceFactory(AppConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }

            /** {@inheritDoc} */
            protected void configure(Configuration configuration) {
                configuration.addAnnotatedClass(AccountDAOImpl.class);
                configuration.addAnnotatedClass(EntryDAOImpl.class);
                configuration.addAnnotatedClass(BasicTransactionDAOImpl.class);
                configuration.addAnnotatedClass(PartyDAOImpl.class);
                configuration.addAnnotatedClass(InvoiceDAOImpl.class);
                configuration.addAnnotatedClass(TaxEntryDAOImpl.class);
                configuration.addAnnotatedClass(TaxTableDAOImpl.class);
                configuration.addAnnotatedClass(TaxTableRowDAOImpl.class);
                configuration.addAnnotatedClass(TaxTableEntryDAOImpl.class);
                extensionPoint.addHibernateClasses(configuration);
            }
        };

    /** The bean validation resource bundle. */
    private final BeanValidationBundle<AppConfiguration> beanValidationBundle =
        new BeanValidationBundle<AppConfiguration>() {
            /** {@inheritDoc} */
            public ValidatorFactory getValidatorFactory(AppConfiguration configuration) {
                String constraintsResource = configuration.getBeanValidationConstraints();
                InputStream resource = this.getClass().getClassLoader().getResourceAsStream(constraintsResource);

                return Validation.byDefaultProvider().configure().addMapping(resource).buildValidatorFactory();
            }
        };

    /** The reference data initialization bundle. */
    RefDataSetupBundle<AppConfiguration> refDataSetupBundle =
        new RefDataSetupBundle<AppConfiguration>() {
            /** {@inheritDoc} */
            public String getRefdataPackage(AppConfiguration configuration) {
                return configuration.getRefdata();
            }

            /** {@inheritDoc} */
            public DataSourceFactory getDataSourceFactory(AppConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        };

    /** The database migration resource bundle. */
    private final MigrationsBundle<AppConfiguration> migrationsBundle =
        new MigrationsBundle<AppConfiguration>() {
            /** {@inheritDoc} */
            public DataSourceFactory getDataSourceFactory(AppConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        };

    /** Create the extension point. */
    private Example extensionPoint = new Example();

    /**
     * Starts the Accounts application running.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        try {
            new Main().run(args);
        } catch (Exception e) {
            throw new IllegalStateException("Application failed with an exception.", e);
        }
    }

    /** {@inheritDoc} */
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        bootstrap.addBundle(migrationsBundle);
        bootstrap.addBundle(hibernateXmlBundle);
        bootstrap.addBundle(refDataSetupBundle);
        bootstrap.addBundle(beanValidationBundle);
        bootstrap.addBundle(new ViewBundle());

        bootstrap.addCommand(refDataLoadCommand);
        bootstrap.addCommand(dropViewsCommand);

        bootstrap.getObjectMapper().registerModule(new JodaTimeModule());
        bootstrap.getObjectMapper().configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
        bootstrap.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        bootstrap.getObjectMapper().configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true);
        bootstrap.getObjectMapper().configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        bootstrap.getObjectMapper().registerModule(new HalResourceModule());

        extensionPoint.bootstrap(bootstrap);
    }

    /** {@inheritDoc} */
    public void run(AppConfiguration ppConfiguration, Environment environment) throws ParseException {
        if (!hyperExpressInitialized) {
            HalResourceFactory halFactory = new HalResourceFactory();
            HyperExpress.registerResourceFactoryStrategy(halFactory, "application/hal+json");

            hyperExpressInitialized = true;
        }

        SessionFactory sessionFactory = hibernateXmlBundle.getSessionFactory();

        environment.jersey().register(new StandardExceptionMapper());
        environment.jersey().register(MultiPartFeature.class);

        // Obtain a reference to the validator.
        ValidatorFactory validatorFactory = beanValidationBundle.getValidatorFactory(ppConfiguration);

        // Set up the DAOs on top of Hibernate and the validator.
        AccountDAO accountDAO = new AccountDAOImpl(sessionFactory, validatorFactory);
        EntryDAO entryDAO = new EntryDAOImpl(sessionFactory, validatorFactory);
        BasicTransactionDAO basicTransactionDAO = new BasicTransactionDAOImpl(sessionFactory, validatorFactory);
        PartyDAO partyDAO = new PartyDAOImpl(sessionFactory, validatorFactory);
        InvoiceDAO invoiceDAO = new InvoiceDAOImpl(sessionFactory, validatorFactory);
        TaxEntryDAO taxEntryDAO = new TaxEntryDAOImpl(sessionFactory, validatorFactory);
        TaxTableDAO taxTableDAO = new TaxTableDAOImpl(sessionFactory, validatorFactory);
        TaxTableRowDAO taxTableRowDAO = new TaxTableRowDAOImpl(sessionFactory, validatorFactory);
        TaxTableEntryDAO taxTableEntryDAO = new TaxTableEntryDAOImpl(sessionFactory, validatorFactory);

        // Build all of the services on top of the DAOs.
        ReferenceDataResource referenceDataResource = new ReferenceDataResource(refDataSetupBundle.getRefdataTypes());

        AccountResource accountResource = new AccountResource(accountDAO);
        EntryResource entryResource = new EntryResource(entryDAO);
        BasicTransactionResource basicTransactionResource = new BasicTransactionResource(basicTransactionDAO);
        PartyResource partyResource = new PartyResource(partyDAO);
        InvoiceResource invoiceResource = new InvoiceResource(invoiceDAO);
        TaxEntryResource taxEntryResource = new TaxEntryResource(taxEntryDAO);
        TaxTableResource taxTableResource = new TaxTableResource(taxTableDAO);
        TaxTableRowResource taxTableRowResource = new TaxTableRowResource(taxTableRowDAO);
        TaxTableEntryResource taxTableEntryResource = new TaxTableEntryResource(taxTableEntryDAO);

        ServiceFactory serviceFactory =
            new LocalServiceFactory(sessionFactory,
            accountResource, 
            entryResource, 
            basicTransactionResource, 
            partyResource, 
            invoiceResource, 
            taxEntryResource, 
            taxTableResource, 
            taxTableRowResource, 
            taxTableEntryResource
        );

        // Register the REST APIs.
        environment.jersey().register(referenceDataResource);
        environment.jersey().register(accountResource);
        environment.jersey().register(entryResource);
        environment.jersey().register(basicTransactionResource);
        environment.jersey().register(partyResource);
        environment.jersey().register(invoiceResource);
        environment.jersey().register(taxEntryResource);
        environment.jersey().register(taxTableResource);
        environment.jersey().register(taxTableRowResource);
        environment.jersey().register(taxTableEntryResource);

        environment.jersey().setUrlPattern("/*");

        // Run the example to create some example data.
        extensionPoint.initAdditionalServices(ppConfiguration, environment, sessionFactory,
            validatorFactory, serviceFactory);
        extensionPoint.example(serviceFactory);
    }
}