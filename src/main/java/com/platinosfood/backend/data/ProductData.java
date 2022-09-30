package com.platinosfood.backend.data;

import com.platinosfood.backend.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductData {

    private int id;
    private String name;
    private int quantity;
    private double price;
    private String image;
    private String description;
    private boolean enable;
    private Category category;
}
