package io.jotech.classicmodels.service.impl;

import java.util.List;

import jakarta.inject.Inject;

import io.jotech.classicmodels.entity.Order;
import io.jotech.classicmodels.repository.OrderRepository;
import io.jotech.classicmodels.service.OrderService;

public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders(Integer start, Integer limit) {
        return orderRepository.listAll(start,limit);
    }
}
