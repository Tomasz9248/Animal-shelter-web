package com.tomek.controller;

import com.tomek.data.Dog;
import com.tomek.util.ConnectionProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ListServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Dog> animalList = getAnimals();
        request.setAttribute("animalList", animalList);

        request.getRequestDispatcher("animalList.jsp").forward(request,response);

}

private List<Dog> getAnimals() {
    String query = "SELECT Name, Race, Age, isFetching, isPurebred FROM dog";

    List<Dog> animaList = new ArrayList<>();
    try (
            Connection con = ConnectionProvider.getConnection();
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);) {
        while (resultSet.next()) {
            String name = resultSet.getString("Name");
            String race = resultSet.getString("Race");
            Integer age = resultSet.getInt("Age");
            String isFetching = resultSet.getString("isFetching");
            String isPurebred = resultSet.getString("isPurebred");

            animaList.add(new Dog(name, race, age, isFetching, isPurebred));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return animaList;
}
}
