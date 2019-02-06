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

public class DeleteDogController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String operation = request.getParameter("option");
        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.MYSQL_FACTORY);
            DogDao dao = factory.getDogDao();

            Dog dog = null;
            dog = dao.read(name);
            dao.delete(dog);

            request.setAttribute("dog", dog);
            request.setAttribute("operation", operation);
            request.getRequestDispatcher("dogResult.jsp").forward(request, response);
    } catch(
    DbOperationException e)
    {
        e.printStackTrace();
    } catch(
    NullPointerException ne)
    {
        response.sendRedirect("nullPointer.jsp");
    }
}
}