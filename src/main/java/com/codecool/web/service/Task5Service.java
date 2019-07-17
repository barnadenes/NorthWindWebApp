package com.codecool.web.service;

import com.codecool.web.dao.database.Task5DAO;
import com.codecool.web.model.Task5;

import java.sql.SQLException;
import java.util.List;

public final class Task5Service {
    private final Task5DAO task5DAO;

    public Task5Service(Task5DAO task5DAO) {
        this.task5DAO = task5DAO;
    }

    public List<Task5> getTask4() throws SQLException {
        return task5DAO.task5List();
    }

    public List<Task5> getTask4Filtered(String company) throws SQLException {
        return task5DAO.task5ListFiltered(company);
    }
}
