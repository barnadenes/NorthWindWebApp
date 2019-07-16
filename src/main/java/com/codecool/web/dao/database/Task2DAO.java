package com.codecool.web.dao.database;

import com.codecool.web.model.Task2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class Task2DAO extends AbstractDao{

    public Task2DAO(Connection connection) {
        super(connection);
    }

    public List<Task2> task2List() throws SQLException {
        List<Task2> task2s = new ArrayList<>();
        String sql = "select company_name as company, count(company_name) as NumberOfProducts from suppliers " +
        "inner join products on suppliers.supplier_id = products.supplier_id " +
        "group by company_name " +
        "order by count(company_name) desc, company";

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql))
        {
            while (rs.next()) {
                Task2 task2 = new Task2(rs.getString("company"),
                    rs.getInt("NumberOfProducts"));
                task2s.add(task2);
            }
        }
        return task2s;
    }

    public List<Task2> task2ListFiltered(String company) throws SQLException {
        List<Task2> task2s = new ArrayList<>();
        String sql = "select company_name as company, count(company_name) as NumberOfProducts from suppliers " +
            "inner join products on suppliers.supplier_id = products.supplier_id " +
            "where company_name like ? " +
            "group by company_name " +
            "order by count(company_name) desc, company";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
             ps.setString(1, "%" + company + "%");
             ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Task2 task2 = new Task2(rs.getString("company"),
                                        rs.getInt("NumberOfProducts"));
                task2s.add(task2);
            }
        }
        return task2s;
    }
}
