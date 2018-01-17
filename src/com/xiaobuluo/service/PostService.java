package com.xiaobuluo.service;

import com.xiaobuluo.entity.Post;

public interface PostService {
    void addPost(Post post);
    void editPost(Post post);
    void deletePost(Post post);
}
