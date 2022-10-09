package com.platinosfood.backend.entities;

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
public class Article {

    private int id;
    private String name;
    private int quantity;
    private double price;
    private String image;
    private String description;
}
