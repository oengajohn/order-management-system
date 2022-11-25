package io.jotech.classicmodels.repository;

import io.jotech.base.repository.JpaRepository;
import io.jotech.classicmodels.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
