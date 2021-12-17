package com.netcracker.application.controller;

import com.netcracker.application.service.ProductService;
import com.netcracker.application.service.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllProducts() {
        return ResponseEntity.ok(productService.getAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity getProductById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.getById(id));

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createProduct(@RequestBody Product product) {
        productService.create(product);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        productService.update(id, product);
        return ResponseEntity.ok().build();

    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        productService.delete(id);
        return ResponseEntity.ok().build();

    }
}
