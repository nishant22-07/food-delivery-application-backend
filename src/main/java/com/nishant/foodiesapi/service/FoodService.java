package com.nishant.foodiesapi.service;

import org.springframework.web.multipart.MultipartFile;

public interface FoodService {
    String uploadFile(MultipartFile file);

}
