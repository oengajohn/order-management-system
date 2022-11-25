package io.jotech.classicmodels.repository;

import io.jotech.base.repository.JpaRepository;
import io.jotech.classicmodels.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
