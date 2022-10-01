package com.platinosfood.backend.services.impl;

import com.platinosfood.backend.entities.Product;
import com.platinosfood.backend.repositories.ProductRepository;
import com.platinosfood.backend.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategoryId(Integer categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }

    @Override
    public Product AddProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product editProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

}
