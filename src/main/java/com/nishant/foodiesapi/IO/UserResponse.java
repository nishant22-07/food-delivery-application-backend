package com.nishant.foodiesapi.IO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    @Id
    private String id;
    private String name;
    private String email;
}
