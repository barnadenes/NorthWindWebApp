package com.codecool.web.servlet;

import com.codecool.web.dao.database.Task4DAO;
import com.codecool.web.service.Task4Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/task4")
public final class Task4Servlet extends AbstractServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(getServletContext())) {
            Task4DAO task4DAO = new Task4DAO(connection);
            Task4Service task4Service = new Task4Service(task4DAO);
            req.setAttribute("output", task4Service.getTask4());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("task4.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(getServletContext())) {
            Task4DAO task4DAO = new Task4DAO(connection);
            Task4Service task4Service = new Task4Service(task4DAO);
            String company = req.getParameter("company");
            req.setAttribute("output", task4Service.getTask4Filtered(company));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("task4.jsp").forward(req, resp);
    }
}
