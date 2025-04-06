package com.scalar.bloggerapp_springboot.users;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.Nullable;
import org.springframework.lang.NonNull;

@Getter
@Setter
@ToString
@Entity(name = "users")
@Builder
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable= false)
    private Long id;

    @Column(nullable = false)
    @NonNull
    private String username;

    @Column(nullable = false)
    @NonNull
    private String email;

    @Column(nullable = true)
    @Nullable
    private String bio;

    @Column(nullable = true)
    @Nullable
    private String image;
}
