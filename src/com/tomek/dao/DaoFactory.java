package com.tomek.dao;

public abstract class DaoFactory {

    public static final int MYSQL_FACTORY = 1;

    public abstract DogDao getDogDao();

    public abstract UserDao getUserDao();

    private static DaoFactory instane;

    public static DaoFactory getDaoFactory(int typeFactory) {
        if (instane == null) {
            if (typeFactory == MYSQL_FACTORY) {
                instane = new MysqlDaoFactory();
            }
        }
        return instane;
    }
}
