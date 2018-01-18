package com.xiaobuluo.service;

import com.xiaobuluo.entity.Comment;

public interface CommentService {
    void addCommentToPost(Comment comment);
    void deleteCommentById(int id);
}
