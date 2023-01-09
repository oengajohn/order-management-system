package io.jotech.classicmodels.service.impl;

import java.util.List;
import jakarta.inject.Inject;

import io.jotech.classicmodels.entity.OrderDetail;
import io.jotech.classicmodels.repository.OrderDetailRepository;

public class OrderDetailServiceImpl implements io.jotech.classicmodels.service.OrderDetailService {


    @Inject
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> getAllOrderDetails(Integer start, Integer limit) {
        return orderDetailRepository.listAll(start, limit);
    }
}
