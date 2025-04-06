package com.scalar.bloggerapp_springboot.users.dtos;

import lombok.Data;

@Data
public class CreateUserResponse {

    private Long id;
    private String username;
    private String email;
    private String bio;
    private String image;
}
