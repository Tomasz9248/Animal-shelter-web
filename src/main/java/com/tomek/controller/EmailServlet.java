package com.tomek.controller;

import com.tomek.data.WelcomeEmail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String emailAddress = request.getParameter("emailAddress");

        WelcomeEmail.runMail(emailAddress);

        request.setAttribute("username", username);
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}