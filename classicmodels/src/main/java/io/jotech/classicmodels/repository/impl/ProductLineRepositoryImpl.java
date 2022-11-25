package io.jotech.classicmodels.repository.impl;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import io.jotech.base.repository.impl.JpaRepositoryImpl;
import io.jotech.classicmodels.entity.ProductLine;
import io.jotech.classicmodels.repository.ProductLineRepository;

public class ProductLineRepositoryImpl extends JpaRepositoryImpl<ProductLine, String> implements ProductLineRepository {

    @Inject
    private EntityManager entityManager;

    protected ProductLineRepositoryImpl() {
        super(ProductLine.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
