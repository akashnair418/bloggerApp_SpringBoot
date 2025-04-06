package com.scalar.bloggerapp_springboot.users;

import com.scalar.bloggerapp_springboot.users.dtos.CreateUserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UsersServiceTest {

    @Autowired
    UserService userService;

    @Test
    void can_create_users() {
        var user = userService.createUser(new CreateUserRequest(
                "akash",
                "pas1223",
                "akash@gmail.com"
        ));

        Assertions.assertNotNull(user);
        Assertions.assertEquals("akash", user.getUsername());
    }
}
