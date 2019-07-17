package com.codecool.web.servlet;

import com.codecool.web.dao.database.Task5DAO;
import com.codecool.web.service.Task5Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/task5")
public final class Task5Servlet extends AbstractServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(getServletContext())) {
            Task5DAO task5DAO = new Task5DAO(connection);
            Task5Service task5Service = new Task5Service(task5DAO);
            req.setAttribute("output", task5Service.getTask4());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("task5.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(getServletContext())) {
             Task5DAO task5DAO = new Task5DAO(connection);
             Task5Service task5Service = new Task5Service(task5DAO);
             String Company = req.getParameter("company");
             req.setAttribute("output", task5Service.getTask4Filtered(Company));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("task5.jsp").forward(req, resp);
    }
}
