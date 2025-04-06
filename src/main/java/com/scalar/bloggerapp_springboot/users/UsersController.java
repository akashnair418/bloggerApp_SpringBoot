package com.scalar.bloggerapp_springboot.users;

import com.scalar.bloggerapp_springboot.users.dtos.CreateUserRequest;
import com.scalar.bloggerapp_springboot.users.dtos.CreateUserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UsersController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    ResponseEntity<CreateUserResponse> signupUsers(@RequestBody CreateUserRequest request){
        UserEntity savedUser = userService.createUser(request);
        URI savedUserUri = URI.create("/users/" + savedUser.getId());
        return ResponseEntity.created(savedUserUri)
                .body(modelMapper.map(savedUser,CreateUserResponse.class));
    }

    @PostMapping("/login")
    void loginUsers(@RequestBody CreateUserRequest request){

    }
}
