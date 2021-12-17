package com.netcracker.application.service.cache;

import com.netcracker.application.service.model.Product;
import com.netcracker.application.service.model.User;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ProductCache {
    private final Map<Integer, Product> products = new HashMap<>();

    public List<Product> getAll() {
        return new ArrayList<>(products.values());
    }

    public Product getById(Integer id) {
        return products.get(id);
    }

    public void save(Product product) {
        if (Objects.isNull(product.getId())) {
            product.setId(ThreadLocalRandom.current().nextInt());
        }
        products.put(product.getId(), product);
    }

    public void delete(Integer id) {
        products.remove(id);
    }
}
