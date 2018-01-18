package com.xiaobuluo.dao;

import com.xiaobuluo.entity.User;

/**
 * Created by DylanHo on 18/01/2018.
 * Email: imhhb1997@gmail.com
 */
public interface UserDao {
    public User getUserById(int id);

    public void saveUser(User user);

    public void updateUserPassword(User user);

    public User getUserByCondition(String condition);
}
