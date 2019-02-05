package com.tomek.dao;

import com.tomek.data.User;

public interface UserDao {

    public User create(User user);

    public User read(String userName);

    public void update(User user);

    public void delete(User user);
}