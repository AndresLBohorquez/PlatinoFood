package com.platinosfood.backend.converters;

import com.platinosfood.backend.data.CategoryData;
import com.platinosfood.backend.entities.Category;

public class CategoryConverter extends Converter<Category, CategoryData> {

    @Override
    public Category toEntity(CategoryData object) {
        return object == null ? null : Category.builder()
                .id(object.getId())
                .name(object.getName())
                .build();
    }

    @Override
    public CategoryData toData(Category object) {
        return object == null ? null : CategoryData.builder()
                .id(object.getId())
                .name(object.getName())
                .build();
    }

}
