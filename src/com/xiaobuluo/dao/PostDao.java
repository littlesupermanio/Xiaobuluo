package com.xiaobuluo.dao;

import com.xiaobuluo.entity.Post;

import java.util.List;

public interface PostDao {
    public List<Post> getAllPosts();

    public Post getPostById(int id);

    public List<Post> getPostsByUserId(int id);

    public List<Post> getPostsBySectionId(int id);

    public void deletePostById(int id);

    public int getPostsCountByUserId(int id);

}
