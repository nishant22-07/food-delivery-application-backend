package com.nishant.foodiesapi.controller;

import com.nishant.foodiesapi.IO.UserRequest;
import com.nishant.foodiesapi.IO.UserResponse;
import com.nishant.foodiesapi.entity.UserEntity;
import com.nishant.foodiesapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin("*")
public class UserController {

    @Autowired
    private final UserService userService;


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse registerUser(@RequestBody UserRequest userRequest) {
        return userService.registerUser(userRequest);

    }

}
