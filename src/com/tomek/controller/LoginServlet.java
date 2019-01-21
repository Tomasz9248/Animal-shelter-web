package com.tomek.controller;

import com.tomek.util.ConnectionProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String query = "SELECT * FROM user WHERE user_name = ? AND password = ?;";

        try (
                Connection con = ConnectionProvider.getConnection();
                PreparedStatement stmt = con.prepareStatement(query);) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                request.getSession(true).setAttribute("username", username);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {

                response.sendRedirect("error.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
