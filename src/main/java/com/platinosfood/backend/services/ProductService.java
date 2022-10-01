package com.platinosfood.backend.services;

import com.platinosfood.backend.entities.Product;
import java.util.List;

public interface ProductService {

    public List<Product> getProducts();

    public List<Product> getProductsByCategoryId(Integer categoryId);

    public Product AddProduct(Product product);

    public Product getProductById(int id);

    public Product editProduct(Product product);

    public void deleteProduct(int id);

}
