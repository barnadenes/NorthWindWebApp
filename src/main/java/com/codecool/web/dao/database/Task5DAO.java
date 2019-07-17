package com.codecool.web.dao.database;

import com.codecool.web.model.Task5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class Task5DAO extends AbstractDao{

    public Task5DAO(Connection connection) {
        super(connection);
    }

    public List<Task5> task5List() throws SQLException {
        List<Task5> task5s = new ArrayList<>();

        String sql = "select company_name as Company, " +
        "product_name as Product, " +
        "unit_price as Price from Products " +
        "join suppliers on suppliers.supplier_id = products.supplier_id " +
        "join (select supplier_id, max(products.unit_price) as price from products " +
        "group by products.supplier_id) as Filtered on products.supplier_id = Filtered.supplier_id " +
        "and products.unit_price = Filtered.price " +
        "order by unit_price desc";

        try(Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql)) {
            while(rs.next()) {
                Task5 task5 = new Task5(rs.getString("Company"),
                                        rs.getString("Product"),
                                        rs.getString("Price"));
                task5s.add(task5);
            }
        }
        return task5s;
    }

    public List<Task5> task5ListFiltered(String company) throws SQLException {
        List<Task5> task5s = new ArrayList<>();

        String sql = "select company_name as Company, " +
            "product_name as Product, " +
            "unit_price as Price from Products " +
            "join suppliers on suppliers.supplier_id = products.supplier_id " +
            "join (select supplier_id, max(products.unit_price) as price from products " +
            "group by products.supplier_id) as Filtered on products.supplier_id = Filtered.supplier_id " +
            "and products.unit_price = Filtered.price " +
            "where company_name like ? " +
            "order by unit_price desc";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + company + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Task5 task5 = new Task5(rs.getString("Company"),
                                        rs.getString("Product"),
                                        rs.getString("Price"));
                task5s.add(task5);
            }
        }
        return  task5s;
    }
}

