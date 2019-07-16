package com.codecool.web.dao.database;

import com.codecool.web.model.Task3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class Task3DAO extends AbstractDao{

    public Task3DAO(Connection connection) {
        super(connection);
    }

    public List<Task3> task3List () throws SQLException {
        List<Task3> task3s = new ArrayList<>();

        String sql = "select company_name as company from suppliers " +
        "join products on suppliers.supplier_id = products.supplier_id " +
        "group by company_name " +
        "having count(product_name) = 5 " +
        "order by company_name";

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while(rs.next()) {
                Task3 task3 = new Task3(rs.getString("company"));
                task3s.add(task3);
            }
        }
        return task3s;
    }

    public List<Task3> task3ListFiltered (String company) throws SQLException {
        List<Task3> task3s = new ArrayList<>();

        String sql = "select company_name as company from suppliers " +
            "join products on suppliers.supplier_id = products.supplier_id " +
            "group by company_name " +
            "having count(product_name) = 5 " +
            "and company_name like ? " +
            "order by company_name";

        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + company + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Task3 task3 = new Task3(rs.getString("company"));
                task3s.add(task3);
            }
        }
        return task3s;
    }
}
