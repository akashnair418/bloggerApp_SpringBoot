package com.scalar.bloggerapp_springboot.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentsRepository commentsRepository;

    public CommentService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }
}
