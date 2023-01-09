package io.jotech.classicmodels.service.impl;

import java.util.List;

import jakarta.inject.Inject;

import io.jotech.classicmodels.entity.ProductLine;
import io.jotech.classicmodels.repository.ProductLineRepository;
import io.jotech.classicmodels.service.ProductLineService;

public class ProductLineServiceImpl implements ProductLineService {
    @Inject
    private ProductLineRepository productLineRepository;
    @Override
    public List<ProductLine> getAllProductLines(Integer start, Integer limit) {
        return productLineRepository.listAll(start, limit);
    }
}
