package com.nishant.foodiesapi.service;

import com.nishant.foodiesapi.IO.UserRequest;
import com.nishant.foodiesapi.IO.UserResponse;

public interface UserService {

    UserResponse registerUser(UserRequest userRequest);

    String findByUserId();

}
