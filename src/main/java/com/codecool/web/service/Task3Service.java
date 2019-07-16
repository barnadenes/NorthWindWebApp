package com.codecool.web.service;

import com.codecool.web.dao.database.Task3DAO;
import com.codecool.web.model.Task3;

import java.sql.SQLException;
import java.util.List;

public final class Task3Service {
    private final Task3DAO task3DAO;

    public Task3Service(Task3DAO task3DAO) {
        this.task3DAO = task3DAO;
    }

    public List<Task3> getTask3 () throws SQLException {
        return task3DAO.task3List();
    }

    public List<Task3> getTask3Filtered(String company) throws SQLException {
        return task3DAO.task3ListFiltered(company);
    }
}
