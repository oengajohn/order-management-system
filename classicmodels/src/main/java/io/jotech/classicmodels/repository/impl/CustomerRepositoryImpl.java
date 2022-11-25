package io.jotech.classicmodels.repository.impl;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import io.jotech.base.repository.impl.JpaRepositoryImpl;
import io.jotech.classicmodels.entity.Customer;
import io.jotech.classicmodels.repository.CustomerRepository;

public class CustomerRepositoryImpl extends JpaRepositoryImpl<Customer, Integer> implements CustomerRepository {
    @Inject
    private EntityManager entityManager;

    protected CustomerRepositoryImpl() {
        super(Customer.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
