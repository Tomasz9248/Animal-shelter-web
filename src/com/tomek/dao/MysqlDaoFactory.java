package com.tomek.dao;

public class MysqlDaoFactory extends DaoFactory {

    @Override
    public DogDao getDogDao() {
        return new MysqlDogDao();
    }

    @Override
    public UserDao getUserDao() {
        return new MysqlUserDao();
    }
}

