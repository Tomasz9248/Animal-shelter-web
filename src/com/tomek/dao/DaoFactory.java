package com.tomek.dao;

public abstract class DaoFactory {

    public static final int MYSQL_FACTORY = 1;

    public abstract DogDao getDogDao();

    public abstract UserDao getUserDao();

    private static DaoFactory instance;

    public static DaoFactory getDaoFactory(int typeFactory) {
        if (instance == null) {
            if (typeFactory == MYSQL_FACTORY) {
                instance = new MysqlDaoFactory();
            }
        }
        return instance;
    }
}