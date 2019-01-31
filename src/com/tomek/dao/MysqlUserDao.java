package com.tomek.dao;

import com.tomek.data.User;
import com.tomek.util.ConnectionProvider;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

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
        BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(user);
        template.update(CREATE, source);
    }

    @Override
    public User read(String user_name) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
