package com.nishant.foodiesapi.IO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodResponce {
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private double price;
    private String category;
}
