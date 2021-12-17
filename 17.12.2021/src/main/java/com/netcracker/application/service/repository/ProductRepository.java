package com.netcracker.application.service.repository;

import com.netcracker.application.service.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
