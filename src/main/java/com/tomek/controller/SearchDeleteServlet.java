package com.tomek.controller;

import com.tomek.dao.DaoFactory;
import com.tomek.dao.DogDao;
import com.tomek.data.Dog;
import com.tomek.util.DbOperationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String option = request.getParameter("option");
        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.MYSQL_FACTORY);
            DogDao dao = factory.getDogDao();

            Dog dog = null;
            String operation = null;
            if ((option).equals("Szukaj")) {
                dog = dao.read(name);
                operation = "read";
            } else if (option.equals("Usuń")) {
                dog = dao.read(name);
                dao.delete(dog);
                operation = "delete";
            }
            if (dog.getName() != null) {
                request.setAttribute("dog", dog);
                request.setAttribute("operation", operation);
                request.getRequestDispatcher("dogResult.jsp").forward(request, response);
            }
        } catch (DbOperationException e) {
            e.printStackTrace();
        } catch (NullPointerException ne) {
                response.sendRedirect("nullPointer.jsp");
        }
    }
}