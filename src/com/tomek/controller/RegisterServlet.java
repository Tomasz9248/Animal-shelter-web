package com.tomek.controller;


import org.apache.commons.validator.EmailValidator;
import com.tomek.dao.DaoFactory;
import com.tomek.dao.UserDao;
import com.tomek.data.User;
import com.tomek.util.DbOperationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String user_name = request.getParameter("username");
        String password = request.getParameter("password");
        String email_address = request.getParameter("emailAddress");



        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.MYSQL_FACTORY);
            UserDao dao = factory.getUserDao();

            User user = new User(user_name, password, email_address);
            dao.create(user);

            EmailValidator validator = EmailValidator.getInstance();
            if (validator.isValid(email_address)) {
                request.setAttribute("emailAddress", email_address);
                request.setAttribute("username", user_name);
                request.getRequestDispatcher("/EmailServlet").forward(request, response);
            } else {
                response.sendRedirect("register.jsp");
            }


        } catch (DbOperationException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
