package com.nishant.foodiesapi.service;

import com.nishant.foodiesapi.IO.FoodRequest;
import com.nishant.foodiesapi.IO.FoodResponce;
import com.nishant.foodiesapi.repository.FoodRepository;
import org.springframework.web.multipart.MultipartFile;

public interface FoodService {
    String uploadFile(MultipartFile file);


    FoodResponce addFood(FoodRequest request , MultipartFile file);
}
