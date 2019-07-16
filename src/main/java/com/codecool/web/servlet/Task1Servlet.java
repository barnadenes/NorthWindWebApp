package com.codecool.web.servlet;

import com.codecool.web.dao.database.Task1DAO;
import com.codecool.web.service.Task1Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/task1")
public final class Task1Servlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task1DAO task1Dao = new Task1DAO(connection);
            Task1Service task1Service = new Task1Service(task1Dao);
            req.setAttribute("output", task1Service.getTask1());

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task1.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task1DAO task1Dao = new Task1DAO(connection);
            Task1Service task1Service = new Task1Service(task1Dao);
            String company = req.getParameter("company");
            req.setAttribute("output", task1Service.getTask1Filtered(company));

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task1.jsp").forward(req, resp);
    }
}
