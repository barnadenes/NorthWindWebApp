package com.codecool.web.service;

import com.codecool.web.dao.database.Task2DAO;
import com.codecool.web.model.Task2;

import java.sql.SQLException;
import java.util.List;

public final class Task2Service {
    private final Task2DAO task2DAO;

    public Task2Service(Task2DAO task2DAO) {
        this.task2DAO = task2DAO;
    }

    public List<Task2> getTask2 () throws SQLException {
        return task2DAO.task2List();
    }

    public List<Task2> getTask2Filtered(String company) throws SQLException {
        return task2DAO.task2ListFiltered(company);
    }
}
