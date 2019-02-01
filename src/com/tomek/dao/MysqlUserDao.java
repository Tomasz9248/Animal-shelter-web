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

    private static final String CREATE = "INSERT INTO user (user_name, password, email_address) VALUES (:user_name, :password, :email_address);";
    private static final String READ = "SELECT * FROM user WHERE user_name = :user_name;";
    private static final String UPDATE = "UPDATE user SET user_name = :user_name, password = :password, email_address = :email_address WHERE user_name = :user_name;";
    private static final String DELETE = "DELETE FROM user WHERE user_name = :user_name;";

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
    public User read(String user_name) {
        User resultUser = null;
        SqlParameterSource namedParameter = new MapSqlParameterSource("user_name",user_name);

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
        SqlParameterSource namedParameter = new MapSqlParameterSource("user_name", user.getUser_name());
        template.update(DELETE, namedParameter);

    }
}
