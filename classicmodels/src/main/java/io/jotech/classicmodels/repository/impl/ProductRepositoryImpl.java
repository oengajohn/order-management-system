package io.jotech.classicmodels.repository.impl;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import io.jotech.base.repository.impl.JpaRepositoryImpl;
import io.jotech.classicmodels.entity.Product;
import io.jotech.classicmodels.repository.ProductRepository;

public class ProductRepositoryImpl  extends JpaRepositoryImpl<Product, String> implements ProductRepository {

    @Inject
    private EntityManager  entityManager;

    protected ProductRepositoryImpl() {
        super(Product.class);
    }

    @Override
    protected EntityManager getEntityManager() {
       return entityManager;
        }
}
