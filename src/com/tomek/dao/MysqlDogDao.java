package com.tomek.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import com.tomek.data.Dog;
import com.tomek.util.ConnectionProvider;

import java.util.List;


public class MysqlDogDao implements DogDao {

    private static final String CREATE = "INSERT INTO dog (name, race, age, isFetching, isPurebred) VALUES (:name, :race, :age, :isFetching, :isPurebred);";
    private static final String READ = "SELECT name, race, age, isFetching, isPurebred FROM dog WHERE name = :name;";
    private static final String UPDATE = "UPDATE dog SET name = :name, race = :race, age = :age, isFetching = :isFetching, isPurebred = :isPurebred WHERE name = :name;";
    private static final String DELETE = "DELETE FROM dog WHERE name = :name;";

    private NamedParameterJdbcTemplate template;

    public MysqlDogDao() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDSInstance());
    }

    @Override
    public void create(Dog dog) {
        BeanPropertySqlParameterSource beanParamSource = new BeanPropertySqlParameterSource(dog);
        template.update(CREATE, beanParamSource);
    }

    @Override
    public Dog read(String name) {
        Dog resultDog = null;
        SqlParameterSource namedParameter = new MapSqlParameterSource("name", name);
        List<Dog> dogList = template.query(READ, namedParameter, BeanPropertyRowMapper.newInstance(Dog.class));

       if (dogList.size() > 0) {
            resultDog = dogList.get(0);
        }
        return resultDog;
    }

    @Override
    public void update(Dog dog) {
        BeanPropertySqlParameterSource beanParamSource = new BeanPropertySqlParameterSource(dog);
        template.update(UPDATE, beanParamSource);

    }

    @Override
    public void delete(Dog dog) {
        SqlParameterSource namedParameter = new MapSqlParameterSource("name", dog.getName());
        template.update(DELETE, namedParameter);

    }
}
