package io.jotech.classicmodels.repository.impl;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import io.jotech.base.repository.impl.JpaRepositoryImpl;
import io.jotech.classicmodels.entity.Payment;
import io.jotech.classicmodels.entity.PaymentId;
import io.jotech.classicmodels.repository.PaymentRepository;

public class PaymentRepositoryImpl extends JpaRepositoryImpl<Payment, PaymentId> implements PaymentRepository {

    @Inject
    private EntityManager  entityManager;
    protected PaymentRepositoryImpl() {
        super(Payment.class);
    }

    @Override
    protected EntityManager getEntityManager() {
   return entityManager; }
}
