package com.netcracker.application.service.cache;

import com.netcracker.application.service.model.Product;
import com.netcracker.application.service.model.User;
import com.netcracker.application.service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ProductCache {
    private final Map<Integer, Product> products = new HashMap<>();

    private final ProductRepository productRepository;

    @Autowired
    public ProductCache(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        fillCache();
        return new ArrayList<>(products.values());
    }

    private void fillCache() {
        if (products.isEmpty()) {
            productRepository.findAll().forEach(product -> products.put(product.getId(), product));
        }
    }

    public Product getById(Integer id) {
        fillCache();
        return products.get(id);
    }

    public void save(Product product) {
        productRepository.save(product);
        products.clear();
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
        products.clear();
    }
}
