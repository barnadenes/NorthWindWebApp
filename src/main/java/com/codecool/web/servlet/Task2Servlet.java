package com.codecool.web.servlet;

import com.codecool.web.dao.database.Task2DAO;
import com.codecool.web.model.Task2;
import com.codecool.web.service.Task2Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/task2")
public class Task2Servlet extends AbstractServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task2DAO task2Dao = new Task2DAO(connection);
            Task2Service task2Service = new Task2Service(task2Dao);
            req.setAttribute("output", task2Service.getTask2());

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task2.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task2DAO task2Dao = new Task2DAO(connection);
            Task2Service task2Service = new Task2Service(task2Dao);
            String company = req.getParameter("company");
            req.setAttribute("output", task2Service.getTask2Filtered(company));

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task2.jsp").forward(req, resp);
    }
}
