package com.thesett.accounts.dao;

import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.validation.ValidatorFactory;

import org.hibernate.SessionFactory;

import com.thesett.util.dao.HibernateBaseDAO;
import com.thesett.accounts.model.Party;

/**
 * PartyDAOImpl provides an implementation of the DAO for Party using
 * Hibernate.
 *
 * @author Generated Code
 */
@MappedSuperclass
@NamedQueries({})
public class PartyDAOImpl extends HibernateBaseDAO<Party, Long> implements PartyDAO {
    /**
     * Creates the DAO on the provided Hibernate session factory.
     *
     * @param sessionFactory   The hibernate session factory to use.
     * @param validatorFactory The bean validator factory to use to validate all data prior to insertion.
     */
    public PartyDAOImpl(SessionFactory sessionFactory, ValidatorFactory validatorFactory) {
        super(sessionFactory, validatorFactory);
    }
}
