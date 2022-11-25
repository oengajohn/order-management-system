package io.jotech.classicmodels.service.impl;

import java.util.List;

import javax.inject.Inject;

import io.jotech.classicmodels.entity.Customer;
import io.jotech.classicmodels.repository.CustomerRepository;
import io.jotech.classicmodels.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    @Inject
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.listAll();

    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.insert(customer);
    }

    @Override
    public Customer getCustomer(Integer customerNumber) {
        return customerRepository.read(customerNumber);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.update(customer);
    }

    @Override
    public boolean deleteCustomer(Integer customerNumber) {
        return customerRepository.deleteById(customerNumber);
    }
}
