package io.jotech.classicmodels.repository.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import io.jotech.base.repository.impl.JpaRepositoryImpl;
import io.jotech.classicmodels.entity.OrderDetail;
import io.jotech.classicmodels.entity.OrderDetailID;
import io.jotech.classicmodels.repository.OrderDetailRepository;

public class OrderDetailRepositoryImpl extends JpaRepositoryImpl<OrderDetail, OrderDetailID> implements OrderDetailRepository {


    @Inject
    private EntityManager entityManager;

    protected OrderDetailRepositoryImpl() {
        super(OrderDetail.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
