package com.codecool.web.service;

import com.codecool.web.dao.database.Task4DAO;
import com.codecool.web.model.Task4;

import java.sql.SQLException;
import java.util.List;

public final class Task4Service {
    private final Task4DAO dao;

    public Task4Service(Task4DAO dao) {
        this.dao = dao;
    }

    public List<Task4> getTask4() throws SQLException {
        return dao.task4List();
    }

    public List<Task4> getTask4Filtered (String company) throws SQLException {
        return dao.task4ListFiltered(company);
    }
}
