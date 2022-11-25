package io.jotech.classicmodels.service.impl;

import java.util.List;

import javax.inject.Inject;

import io.jotech.classicmodels.entity.Payment;
import io.jotech.classicmodels.repository.PaymentRepository;
import io.jotech.classicmodels.service.PaymentService;

public class PaymentServiceImpl implements PaymentService {
    @Inject
    private PaymentRepository paymentRepository;
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.listAll();
    }
}
