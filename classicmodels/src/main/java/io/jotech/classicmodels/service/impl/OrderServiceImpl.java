package io.jotech.classicmodels.service.impl;

import java.util.List;

import javax.inject.Inject;

import io.jotech.classicmodels.entity.Order;
import io.jotech.classicmodels.repository.OrderRepository;
import io.jotech.classicmodels.service.OrderService;

public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.listAll();
    }
}
