package com.xiaobuluo.dao;

import com.xiaobuluo.entity.User;

import java.util.List;

/**
 * Created by DylanHo on 18/01/2018.
 * Email: imhhb1997@gmail.com
 */
public interface UserDao {
    public User getUserById(int id);

    public void saveUser(User user);

    public void update(User user);

    public void updateUserPassword(User user);

    public User getUserByCondition(String condition);

    public List<User> getAllUsers();

    public void deleteUser(User user);
}
