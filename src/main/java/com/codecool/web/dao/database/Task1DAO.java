package com.codecool.web.dao.database;

import com.codecool.web.model.Task1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class Task1DAO extends AbstractDao{

    public Task1DAO(Connection connection) {
        super(connection);
    }

    public List<Task1> task1List() throws SQLException {
        List<Task1> task1List = new ArrayList<>();
        String sql = "select product_name as product, company_name as company from products " +
        "join suppliers on products.supplier_id = suppliers.supplier_id " +
        "order by product_name, company_name";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Task1 task1 = new Task1(
                    resultSet.getString("company"),
                    resultSet.getString("product"));
                task1List.add(task1);
            }
        }
        return task1List;
    }

    public List<Task1> task1ListFiltered(String company) throws SQLException {
        List<Task1> task1s = new ArrayList<>();
        String sql = "select product_name as product, company_name as company from products " +
            "join suppliers on products.supplier_id = suppliers.supplier_id " +
            "where company_name like ? " +
            "order by product_name, company_name";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + company + "%");
            ResultSet rs = statement.executeQuery();
                while(rs.next()) {
                    Task1 t1 = new Task1(
                        rs.getString("company"),
                        rs.getString("product"));
                    task1s.add(t1);
                }
        }
        return task1s;
    }
}
