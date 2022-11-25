package io.jotech.classicmodels.repository.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import io.jotech.base.repository.impl.JpaRepositoryImpl;
import io.jotech.classicmodels.entity.Office;
import io.jotech.classicmodels.repository.OfficeRepository;

public class OfficeRepositoryImpl extends JpaRepositoryImpl<Office, String> implements OfficeRepository {


    @Inject
    private EntityManager entityManager;

    protected OfficeRepositoryImpl() {
        super(Office.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
