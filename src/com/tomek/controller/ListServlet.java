package com.tomek.controller;

import com.tomek.data.Animal;
import com.tomek.data.Dog;
import com.tomek.util.ConnectionProvider;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ListServlet extends HttpServlet {

    private NamedParameterJdbcTemplate template;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Dog> animalList = getAnimals();

        request.setAttribute("animalList", animalList);
        request.getRequestDispatcher("animalList.jsp").forward(request, response);
    }

    private List<Dog> getAnimals() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDSInstance());
        String query = "SELECT Name, Race, Age, isFetching, isPurebred FROM dog";

        List<Dog> animaList = template.query(query, BeanPropertyRowMapper.newInstance(Dog.class));
        return animaList;
    }
}