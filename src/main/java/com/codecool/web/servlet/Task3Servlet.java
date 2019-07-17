package com.codecool.web.servlet;

import com.codecool.web.dao.database.Task3DAO;
import com.codecool.web.service.Task3Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/task3")
public final class Task3Servlet extends AbstractServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(getServletContext())) {
            Task3DAO task3DAO = new Task3DAO(connection);
            Task3Service task3Service = new Task3Service(task3DAO);
            req.setAttribute("object", task3Service.getTask3());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("task3.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(getServletContext())) {
            Task3DAO task3DAO = new Task3DAO(connection);
            Task3Service task3Service = new Task3Service(task3DAO);
            String name = req.getParameter("company");
            req.setAttribute("output", task3Service.getTask3Filtered(name));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("task3.jsp").forward(req, resp);
    }
}
