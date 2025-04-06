package com.scalar.bloggerapp_springboot.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(1)
    void can_create_user(){
        var user = UserEntity.builder()
                .username("akash")
                .email("akash@gmail.com")
                .build();
        userRepository.save(user);

    }

    @Test
    @Order(2)
    void can_find_users(){
        var user = UserEntity.builder()
                .username("akash")
                .email("akash@gmail.com")
                .build();
        userRepository.save(user);
        var users= userRepository.findAll();
        assertEquals(1, users.size());
    }
}
