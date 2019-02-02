package com.tomek.dao;

import com.tomek.data.User;
import com.tomek.util.ConnectionProvider;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;

public class MysqlUserDao implements UserDao {

    private static final String CREATE = "INSERT INTO user (userName, password, emailAddress) VALUES (:userName, :password, :emailAddress);";
    private static final String READ = "SELECT * FROM user WHERE userName = :userName;";
    private static final String UPDATE = "UPDATE user SET userName = :userName, password = :password, emailAddress = :emailAddress WHERE userName = :userName;";
    private static final String DELETE = "DELETE FROM user WHERE userName = :userName;";

    private NamedParameterJdbcTemplate template;

    public MysqlUserDao() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDSInstance());
    }

    @Override
    public void create(User user) {
        BeanPropertySqlParameterSource beanParamSource = new BeanPropertySqlParameterSource(user);
        template.update(CREATE, beanParamSource);
    }

    @Override
    public User read(String userName) {
        User resultUser = null;
        SqlParameterSource namedParameter = new MapSqlParameterSource("userName", userName);

        List<User> userList = template.query(READ, namedParameter, BeanPropertyRowMapper.newInstance(User.class));

        if (userList.size() > 0) {
            resultUser = userList.get(0);
        }
        return resultUser;
    }

    @Override
    public void update(User user) {
        BeanPropertySqlParameterSource beanParamSource = new BeanPropertySqlParameterSource(user);
        template.update(UPDATE, beanParamSource);
    }

    @Override
    public void delete(User user) {
        SqlParameterSource namedParameter = new MapSqlParameterSource("userName", user.getUserName());
        template.update(DELETE, namedParameter);
    }
}