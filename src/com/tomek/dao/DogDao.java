package com.tomek.dao;

import com.tomek.data.Dog;


public interface DogDao {

    public void create(Dog dog);

    public Dog read(String name);

    public void update(Dog dog);

    public void delete(Dog dog);
}