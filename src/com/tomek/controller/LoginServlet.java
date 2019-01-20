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
        String query = "SELECT * FROM users WHERE username =? AND password =?;";
        String all = "all";

        try (
                Connection con = ConnectionProvider.getConnection();
                PreparedStatement stmt = con.prepareStatement(query);) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                request.getSession(true).setAttribute("priviliges", all);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {

                response.sendRedirect("login.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
