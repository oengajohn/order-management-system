package io.jotech.classicmodels.service.impl;

import java.util.List;

import jakarta.inject.Inject;

import io.jotech.classicmodels.entity.Product;
import io.jotech.classicmodels.repository.ProductRepository;
import io.jotech.classicmodels.service.ProductService;

public class ProductServiceImpl implements ProductService {
    @Inject
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts(Integer start, Integer limit) {
        return productRepository.listAll(start, limit);
    }
}
