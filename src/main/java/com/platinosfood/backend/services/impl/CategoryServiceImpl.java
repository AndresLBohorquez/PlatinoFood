package com.platinosfood.backend.services.impl;

import com.platinosfood.backend.entities.Category;
import com.platinosfood.backend.repositories.CategoryRepository;
import com.platinosfood.backend.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    

}
