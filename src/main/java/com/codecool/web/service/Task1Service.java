package com.codecool.web.service;

import com.codecool.web.dao.database.Task1DAO;
import com.codecool.web.model.Task1;

import java.sql.SQLException;
import java.util.List;

public final class Task1Service {
    private final Task1DAO task1DAO;

    public Task1Service(Task1DAO task1DAO) {
        this.task1DAO = task1DAO;
    }

    public List<Task1> getTask1() throws SQLException {
        return task1DAO.task1List();
    }

    public List<Task1> getTask1Filtered(String company) throws SQLException {
        return task1DAO.task1ListFiltered(company);
    }
}
