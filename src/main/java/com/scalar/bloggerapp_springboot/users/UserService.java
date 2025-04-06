package com.scalar.bloggerapp_springboot.users;

import com.scalar.bloggerapp_springboot.users.dtos.CreateUserRequest;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(CreateUserRequest req) {
        var newUser = UserEntity.builder()
                .username(req.getUsername())
                .email(req.getEmail())
                .build();
        return userRepository.save(newUser);
    }


    public UserEntity getUser(String username) {
        return userRepository.findByUsername(username).orElseThrow(()-> new UserNotFoundException(username));
    }

    public UserEntity getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new UserService.UserNotFoundException(userId));
    }

    public UserEntity loginUser(String username, String password) {
        var user = userRepository.findByUsername(username).orElseThrow(()-> new UserService.UserNotFoundException(username));
        // TODO: password Match
        return user;
    }

    public static class UserNotFoundException extends IllegalArgumentException {
        public UserNotFoundException(String username) {
            super("User with username : " + username + " not found");
        }

        public UserNotFoundException(Long authorId) {
            super("User with authorId : " + authorId + " not found");
        }    }
}
