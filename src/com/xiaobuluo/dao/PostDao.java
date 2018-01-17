package com.xiaobuluo.dao;

import com.xiaobuluo.entity.Post;

import java.util.List;

public interface PostDao {
    public List<Post> getAllPosts();

    public Post getPostById(int id);

    public void deletePostById(int id);
}
