package com.platinosfood.backend.converters;

import com.platinosfood.backend.data.ProductData;
import com.platinosfood.backend.entities.Product;

public class ProductConverter extends Converter<Product, ProductData> {

    CategoryConverter categoryConverter = new CategoryConverter();

    @Override
    public Product toEntity(ProductData object) {
        return object == null ? null : Product.builder()
                .id(object.getId())
                .name(object.getName())
                .quantity(object.getQuantity())
                .price(object.getPrice())
                .image(object.getImage())
                .description(object.getDescription())
                .enable(object.isEnable())
                //.category(categoryConverter.toEntity(object.getCategory()))
                .build();
    }

    @Override
    public ProductData toData(Product object) {
        return object == null ? null : ProductData.builder()
                .id(object.getId())
                .name(object.getName())
                .quantity(object.getQuantity())
                .price(object.getPrice())
                .image(object.getImage())
                .description(object.getDescription())
                .enable(object.isEnable())
                //.category(categoryConverter.toData(object.getCategory()))
                .build();
    }

}
