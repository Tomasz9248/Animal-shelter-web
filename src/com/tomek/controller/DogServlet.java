package com.tomek.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tomek.dao.DaoFactory;
import com.tomek.dao.DogDao;
import com.tomek.util.DbOperationException;
import com.tomek.data.Dog;


public class DogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String race = request.getParameter("race");
        int age = Integer.parseInt(request.getParameter("age"));
        String isFetching = request.getParameter("isFetching");
        String isPurebred = request.getParameter("isPurebred");
        String option = request.getParameter("option");

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.MYSQL_FACTORY);
            DogDao dao = factory.getDogDao();

            Dog dog = null;
            String operation = null;

            if ("add".equals(option)) {
                dog = new Dog(name, race, age, isFetching, isPurebred);
                dao.create(dog);
                operation = "create";
            } else if ("read".equals(option)) {
                dog = dao.read(name);
                operation = "read";
            } else if ("update".equals(option)) {
                dog = new Dog(name, race, age, isFetching, isPurebred);
                dao.update(dog);
                operation = "update";
            } else if ("delete".equals(option)) {
                dog = dao.read(name);
                dao.delete(dog);
                operation = "deleter";
            }

            request.setAttribute("dog", dog);
            request.setAttribute("operation", operation);
            request.getRequestDispatcher("dogResult.jsp").forward(request,response);

        } catch (DbOperationException e) {
            e.printStackTrace();
        }
    }
}