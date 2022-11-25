package io.jotech.base.producers;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class EntityManagerProducer {

    @PersistenceContext
    private EntityManager em;

    @Produces
    public EntityManager getEntityManager() {
        return em;
    }

}