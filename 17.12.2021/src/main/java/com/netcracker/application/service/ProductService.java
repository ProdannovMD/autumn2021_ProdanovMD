package com.netcracker.application.service;

import com.netcracker.application.service.cache.ProductCache;
import com.netcracker.application.service.cache.UserCache;
import com.netcracker.application.service.model.Product;
import com.netcracker.application.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Objects;

@Component
public class ProductService {
    private final ProductCache productCache;

    @Autowired
    public ProductService(ProductCache productCache) {
        this.productCache = productCache;
    }

    public List<Product> getAll() {
        return productCache.getAll();
    }

    public Product getById(Integer id) {
        return productCache.getById(id);
    }

    public void create(Product product) {
        productCache.save(product);
    }

    public void update(Integer id, Product product) {
        Product productForUpdate = productCache.getById(id);
        if (Objects.isNull(productForUpdate)) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        if (Objects.nonNull(product.getName()))
            productForUpdate.setName(product.getName());
        if (Objects.nonNull(product.getPrice()))
            productForUpdate.setPrice(product.getPrice());

    }

    public void delete(Integer id) {
        productCache.delete(id);
    }
}
