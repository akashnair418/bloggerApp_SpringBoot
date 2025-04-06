package com.scalar.bloggerapp_springboot.articles;

import com.scalar.bloggerapp_springboot.articles.dtos.CreateArticleRequest;
import com.scalar.bloggerapp_springboot.articles.dtos.UpdateArticleRequest;
import com.scalar.bloggerapp_springboot.comments.CommentsRepository;
import com.scalar.bloggerapp_springboot.users.UserRepository;
import com.scalar.bloggerapp_springboot.users.UserService;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public ArticleService(CommentsRepository commentsRepository, ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    public Iterable<ArticleEntity> getAllArticles() {
        return articleRepository.findAll();
    }

    public ArticleEntity getArticleBySlug(String slug) {
        var article = articleRepository.findBySlug(slug);
        if (article == null) {
            throw new ArticleNotFoundException(slug);
        }
        return article;
    }

    public ArticleEntity createNewArticle(CreateArticleRequest a, Long authorId) {
        var author = userRepository.findById(authorId).orElseThrow(()-> new UserService.UserNotFoundException(authorId));
        return articleRepository.save(ArticleEntity.builder()
                .title(a.getTitle())
                .slug(a.getTitle()) //TODO
                .body(a.getBody())
                .subtitle(a.getSubtitle())
                .author(author)
                .build());
    }


    public ArticleEntity updateArticle(Long articleId, UpdateArticleRequest a) {
        var article = articleRepository.findById(articleId).orElseThrow(()-> new ArticleNotFoundException(articleId));

        if(a.getTitle() != null) {
            article.setTitle(a.getTitle());
            article.setSlug(a.getTitle().toLowerCase().replaceAll("\\s+", "-"));
        }
        if(a.getBody() != null)
            article.setBody(a.getBody());
        if(a.getSubtitle() != null)
            article.setSubtitle(a.getSubtitle());
        return articleRepository.save(article);
    }

    static class ArticleNotFoundException extends IllegalArgumentException {
        public ArticleNotFoundException(String slug) {
            super("Article " + slug + " not found");
        }

        public ArticleNotFoundException(Long articleId) {
            super("ArticleId " + articleId + " not found");
        }
    }
}
