package io.jotech.classicmodels.service.impl;

import java.util.List;

import javax.inject.Inject;

import io.jotech.classicmodels.entity.Employee;
import io.jotech.classicmodels.repository.EmployeeRepository;
import io.jotech.classicmodels.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    @Inject
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.listAll();
    }
}
