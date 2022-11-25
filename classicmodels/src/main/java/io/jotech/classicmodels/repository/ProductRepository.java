package io.jotech.classicmodels.repository;

import io.jotech.base.repository.JpaRepository;
import io.jotech.classicmodels.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
