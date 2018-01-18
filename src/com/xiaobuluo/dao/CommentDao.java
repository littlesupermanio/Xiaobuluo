package com.xiaobuluo.dao;

import com.xiaobuluo.entity.Comment;

import java.util.List;

/**
 * Created by DylanHo on 18/01/2018.
 * Email: imhhb1997@gmail.com
 */
public interface CommentDao {
    public List<Comment> getCommentsByPostId(int id);

    public int getCommentsCountByPostId(int id);

    public Comment getCommentById(int id);
}
