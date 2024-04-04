package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.Dao.EmployeeDaoImp;
import com.tapmodles.Employee;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        int salary = Integer.parseInt(request.getParameter("salary"));

        EmployeeDaoImp dao = new EmployeeDaoImp();
        int i = dao.save(new Employee(id, name, email, salary, department));

        if (i > 0) {
            response.sendRedirect("ViewServlet"); // Redirect to the main page or a success page
        } else {
            response.sendRedirect("error.jsp"); // Redirect to an error page
        }
    }
}

