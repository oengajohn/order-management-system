package io.jotech.classicmodels.repository.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import io.jotech.base.repository.impl.JpaRepositoryImpl;
import io.jotech.classicmodels.entity.Employee;
import io.jotech.classicmodels.repository.EmployeeRepository;

public class EmployeeRepositoryImpl extends JpaRepositoryImpl<Employee, Integer> implements EmployeeRepository {

    @Inject
    private EntityManager entityManager;

    protected EmployeeRepositoryImpl() {
        super(Employee.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
