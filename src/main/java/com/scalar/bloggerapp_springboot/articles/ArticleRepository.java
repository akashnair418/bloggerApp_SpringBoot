package com.scalar.bloggerapp_springboot.articles;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    ArticleEntity findBySlug(@NonNull String slug);
}
