package com.thesett.accounts.test;

import java.io.InputStream;

import javax.sql.DataSource;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.Operation;

import io.dropwizard.db.DataSourceFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import com.thesett.test.controllers.HibernateTransactionDAOFactory;
import com.thesett.test.controllers.LocalReflectiveServiceFactory;
import com.thesett.test.controllers.ReflectiveDAOFactory;
import com.thesett.test.controllers.ReflectiveServiceFactory;    
import com.thesett.test.controllers.TestSetupController;
import com.thesett.test.stack.ModelEqualityByValue;
import com.thesett.util.commands.refdata.RefDataLoadCommand;
import com.thesett.util.commands.refdata.RefDataLoadException;
import com.thesett.util.config.refdata.RefDataSetupBundle;
import com.thesett.util.config.validation.BeanValidationBundle;

import com.thesett.accounts.services.ServiceFactory;
import com.thesett.accounts.services.local.LocalServiceFactory;    
import com.thesett.accounts.config.AppConfiguration;
import com.thesett.accounts.dao.AccountDAOImpl;
import com.thesett.accounts.dao.AccountDAO;
import com.thesett.accounts.services.AccountService;
import com.thesett.accounts.services.rest.AccountResource;
import com.thesett.accounts.dao.EntryDAOImpl;
import com.thesett.accounts.dao.EntryDAO;
import com.thesett.accounts.services.EntryService;
import com.thesett.accounts.services.rest.EntryResource;
import com.thesett.accounts.dao.BasicTransactionDAOImpl;
import com.thesett.accounts.dao.BasicTransactionDAO;
import com.thesett.accounts.services.BasicTransactionService;
import com.thesett.accounts.services.rest.BasicTransactionResource;
import com.thesett.accounts.dao.PartyDAOImpl;
import com.thesett.accounts.dao.PartyDAO;
import com.thesett.accounts.services.PartyService;
import com.thesett.accounts.services.rest.PartyResource;
import com.thesett.accounts.dao.InvoiceDAOImpl;
import com.thesett.accounts.dao.InvoiceDAO;
import com.thesett.accounts.services.InvoiceService;
import com.thesett.accounts.services.rest.InvoiceResource;
import com.thesett.accounts.dao.TaxEntryDAOImpl;
import com.thesett.accounts.dao.TaxEntryDAO;
import com.thesett.accounts.services.TaxEntryService;
import com.thesett.accounts.services.rest.TaxEntryResource;
import com.thesett.accounts.dao.TaxTableDAOImpl;
import com.thesett.accounts.dao.TaxTableDAO;
import com.thesett.accounts.services.TaxTableService;
import com.thesett.accounts.services.rest.TaxTableResource;
import com.thesett.accounts.dao.TaxTableRowDAOImpl;
import com.thesett.accounts.dao.TaxTableRowDAO;
import com.thesett.accounts.services.TaxTableRowService;
import com.thesett.accounts.services.rest.TaxTableRowResource;
import com.thesett.accounts.dao.TaxTableEntryDAOImpl;
import com.thesett.accounts.dao.TaxTableEntryDAO;
import com.thesett.accounts.services.TaxTableEntryService;
import com.thesett.accounts.services.rest.TaxTableEntryResource;

/**
 * AccountsTestSetupController defines some static helper methods for setting up tests. This allows these set up methods
 * to be pulled into tests as needed, with the @BeforeCass annotation.
 *
 * <pre><p/><table id="crc"><caption>CRC Card</caption>
 * <tr><th> Responsibilities </th><th> Collaborations </th>
 * <tr><td> Provide a data source for direct access to the database. </td></tr>
 * <tr><td> Create Hibernate session factory. </td></tr>
 * <tr><td> Load all reference data into the database. </td></tr>
 * <tr><td> Read all reference data from the database into memory. </td></tr>
 * <tr><td> Load the bean validator configuration. </td></tr>
 * </table></pre>
 */
public class AppTestSetupController implements TestSetupController<AppConfiguration>
{
    /** Clears the whole database apart from reference data tables. */
    public static final Operation DELETE_ALL =
        deleteAllFrom(
        );

    /** An equality checker for the model. */
    public static final ModelEqualityByValue MODEL_EQUALITY_BY_VALUE =
        new ModelEqualityByValue(new String[] { "class" });

    /** Used to track the state of the database undergoing testing. */
    private static DbSetupTracker dbTracker = new DbSetupTracker();

    /** {@inheritDoc} */
    public BasicDataSource initDatasource(AppConfiguration configuration)
    {
        DataSourceFactory dataSourceFactory = configuration.getDataSourceFactory();
        BasicDataSource ds = new BasicDataSource();

        ds.setDriverClassName(dataSourceFactory.getDriverClass());
        ds.setUsername(dataSourceFactory.getUser());
        ds.setPassword(dataSourceFactory.getPassword());
        ds.setUrl(dataSourceFactory.getUrl());
        ds.setMaxIdle(1);
        ds.setInitialSize(1);
        ds.setValidationQuery("SELECT 1");

        return ds;
    }

    /** {@inheritDoc} */
    public SessionFactory initHibernateSessionFactory(AppConfiguration configuration)
    {
        DataSourceFactory dataSourceFactory = configuration.getDataSourceFactory();

        Configuration config = new Configuration();
        config.setProperty("hibernate.connection.url", dataSourceFactory.getUrl());
        config.setProperty("hibernate.connection.username", dataSourceFactory.getUser());
        config.setProperty("hibernate.connection.password", dataSourceFactory.getPassword());
        config.setProperty("hibernate.connection.driver_class", dataSourceFactory.getDriverClass());
        config.setProperty("hibernate.current_session_context_class", "thread");
        config.setProperty("hibernate.show_sql", "false");
        config.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        config.addResource("accounts-model.hbm.xml");    
        config.addAnnotatedClass(AccountDAOImpl.class);    
        config.addAnnotatedClass(EntryDAOImpl.class);    
        config.addAnnotatedClass(BasicTransactionDAOImpl.class);    
        config.addAnnotatedClass(PartyDAOImpl.class);    
        config.addAnnotatedClass(InvoiceDAOImpl.class);    
        config.addAnnotatedClass(TaxEntryDAOImpl.class);    
        config.addAnnotatedClass(TaxTableDAOImpl.class);    
        config.addAnnotatedClass(TaxTableRowDAOImpl.class);    
        config.addAnnotatedClass(TaxTableEntryDAOImpl.class);    

        ServiceRegistry serviceRegistry =
            new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

        return config.buildSessionFactory(serviceRegistry);
    }

    /** {@inheritDoc} */
    public void insertReferenceData(AppConfiguration configuration) throws RefDataLoadException
    {
        new RefDataLoadCommand<AppConfiguration>()
            {
                /** {@inheritDoc} */
                public String getRefdataPackage(AppConfiguration configuration)
                {
                    return configuration.getRefdata();
                }

                /** {@inheritDoc} */
                public DataSourceFactory getDataSourceFactory(AppConfiguration configuration)
                {
                    return configuration.getDataSourceFactory();
                }
            }.loadReferenceData(configuration);
    }

    /** {@inheritDoc} */
    public void loadReferenceData(AppConfiguration configuration) throws RefDataLoadException
    {
        new RefDataSetupBundle<AppConfiguration>()
            {
                /** {@inheritDoc} */
                public String getRefdataPackage(AppConfiguration configuration) {
                    return configuration.getRefdata();
                }

                /** {@inheritDoc} */
                public DataSourceFactory getDataSourceFactory(AppConfiguration configuration)
                {
                    return configuration.getDataSourceFactory();
                }
            }.run(configuration, null);    
    }

    /** {@inheritDoc} */
    public ValidatorFactory loadBeanValidation(AppConfiguration configuration)
    {
        BeanValidationBundle beanValidationBundle =
            new BeanValidationBundle<AppConfiguration>()
            {
                /** {@inheritDoc} */
                public ValidatorFactory getValidatorFactory(AppConfiguration configuration)
                {
                    String constraintsResource = configuration.getBeanValidationConstraints();
                    InputStream resource = this.getClass().getClassLoader().getResourceAsStream(constraintsResource);

                    return Validation.byDefaultProvider().configure().addMapping(resource).buildValidatorFactory();
                }
            };
        beanValidationBundle.run(configuration, null);

        return beanValidationBundle.getValidatorFactory(configuration);
    }

    /** {@inheritDoc} */
    public void clearDatabase(DataSource dataSource)
    {
        // Ensure the database is in a known clean state.
        Operation operation = sequenceOf(DELETE_ALL);
        DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource), operation);
        dbTracker.launchIfNecessary(dbSetup);
    }

    /** {@inheritDoc} */
    public ReflectiveDAOFactory getTransactionalReflectiveDAOFactory(SessionFactory sessionFactory,
        ValidatorFactory validatorFactory)
    {
        HibernateTransactionDAOFactory daoFactory =
            new HibernateTransactionDAOFactory(sessionFactory, validatorFactory);

        AccountDAO accountDAO = new AccountDAOImpl(sessionFactory, validatorFactory);
        EntryDAO entryDAO = new EntryDAOImpl(sessionFactory, validatorFactory);
        BasicTransactionDAO basicTransactionDAO = new BasicTransactionDAOImpl(sessionFactory, validatorFactory);
        PartyDAO partyDAO = new PartyDAOImpl(sessionFactory, validatorFactory);
        InvoiceDAO invoiceDAO = new InvoiceDAOImpl(sessionFactory, validatorFactory);
        TaxEntryDAO taxEntryDAO = new TaxEntryDAOImpl(sessionFactory, validatorFactory);
        TaxTableDAO taxTableDAO = new TaxTableDAOImpl(sessionFactory, validatorFactory);
        TaxTableRowDAO taxTableRowDAO = new TaxTableRowDAOImpl(sessionFactory, validatorFactory);
        TaxTableEntryDAO taxTableEntryDAO = new TaxTableEntryDAOImpl(sessionFactory, validatorFactory);

        daoFactory.addDAO(AccountDAO.class, accountDAO);
        daoFactory.addDAO(EntryDAO.class, entryDAO);
        daoFactory.addDAO(BasicTransactionDAO.class, basicTransactionDAO);
        daoFactory.addDAO(PartyDAO.class, partyDAO);
        daoFactory.addDAO(InvoiceDAO.class, invoiceDAO);
        daoFactory.addDAO(TaxEntryDAO.class, taxEntryDAO);
        daoFactory.addDAO(TaxTableDAO.class, taxTableDAO);
        daoFactory.addDAO(TaxTableRowDAO.class, taxTableRowDAO);
        daoFactory.addDAO(TaxTableEntryDAO.class, taxTableEntryDAO);

        return daoFactory;
    }

    /** {@inheritDoc} */
    public ReflectiveServiceFactory getLocalReflectiveServiceFactory(SessionFactory sessionFactory,
        ValidatorFactory validatorFactory)
    {
        LocalReflectiveServiceFactory serviceFactory =
            new LocalReflectiveServiceFactory(sessionFactory, validatorFactory);

        AccountDAO accountDAO = new AccountDAOImpl(sessionFactory, validatorFactory);
        EntryDAO entryDAO = new EntryDAOImpl(sessionFactory, validatorFactory);
        BasicTransactionDAO basicTransactionDAO = new BasicTransactionDAOImpl(sessionFactory, validatorFactory);
        PartyDAO partyDAO = new PartyDAOImpl(sessionFactory, validatorFactory);
        InvoiceDAO invoiceDAO = new InvoiceDAOImpl(sessionFactory, validatorFactory);
        TaxEntryDAO taxEntryDAO = new TaxEntryDAOImpl(sessionFactory, validatorFactory);
        TaxTableDAO taxTableDAO = new TaxTableDAOImpl(sessionFactory, validatorFactory);
        TaxTableRowDAO taxTableRowDAO = new TaxTableRowDAOImpl(sessionFactory, validatorFactory);
        TaxTableEntryDAO taxTableEntryDAO = new TaxTableEntryDAOImpl(sessionFactory, validatorFactory);
    
        AccountResource accountResource = new AccountResource(accountDAO);
        EntryResource entryResource = new EntryResource(entryDAO);
        BasicTransactionResource basicTransactionResource = new BasicTransactionResource(basicTransactionDAO);
        PartyResource partyResource = new PartyResource(partyDAO);
        InvoiceResource invoiceResource = new InvoiceResource(invoiceDAO);
        TaxEntryResource taxEntryResource = new TaxEntryResource(taxEntryDAO);
        TaxTableResource taxTableResource = new TaxTableResource(taxTableDAO);
        TaxTableRowResource taxTableRowResource = new TaxTableRowResource(taxTableRowDAO);
        TaxTableEntryResource taxTableEntryResource = new TaxTableEntryResource(taxTableEntryDAO);

        serviceFactory.addService(AccountService.class, accountResource);
        serviceFactory.addService(EntryService.class, entryResource);
        serviceFactory.addService(BasicTransactionService.class, basicTransactionResource);
        serviceFactory.addService(PartyService.class, partyResource);
        serviceFactory.addService(InvoiceService.class, invoiceResource);
        serviceFactory.addService(TaxEntryService.class, taxEntryResource);
        serviceFactory.addService(TaxTableService.class, taxTableResource);
        serviceFactory.addService(TaxTableRowService.class, taxTableRowResource);
        serviceFactory.addService(TaxTableEntryService.class, taxTableEntryResource);

        return serviceFactory;
    }

    /** {@inheritDoc} */
    public Object getLocalServiceFactory(SessionFactory sessionFactory,
        ValidatorFactory validatorFactory)
    {
        AccountDAO accountDAO = new AccountDAOImpl(sessionFactory, validatorFactory);
        EntryDAO entryDAO = new EntryDAOImpl(sessionFactory, validatorFactory);
        BasicTransactionDAO basicTransactionDAO = new BasicTransactionDAOImpl(sessionFactory, validatorFactory);
        PartyDAO partyDAO = new PartyDAOImpl(sessionFactory, validatorFactory);
        InvoiceDAO invoiceDAO = new InvoiceDAOImpl(sessionFactory, validatorFactory);
        TaxEntryDAO taxEntryDAO = new TaxEntryDAOImpl(sessionFactory, validatorFactory);
        TaxTableDAO taxTableDAO = new TaxTableDAOImpl(sessionFactory, validatorFactory);
        TaxTableRowDAO taxTableRowDAO = new TaxTableRowDAOImpl(sessionFactory, validatorFactory);
        TaxTableEntryDAO taxTableEntryDAO = new TaxTableEntryDAOImpl(sessionFactory, validatorFactory);
    
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

        return serviceFactory;
    }        
}