package com.platinosfood.backend.repositories;

import com.platinosfood.backend.entities.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByCategoryId(Integer categoryId);
}
