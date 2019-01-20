package com.tomek.dao;

import com.tomek.data.User;

public interface UserDao {

    public void create();

    public User read();

    public void update();

    public void delete();
}
