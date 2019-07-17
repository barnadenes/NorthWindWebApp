package com.codecool.web.dao.database;

import com.codecool.web.model.Task4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class Task4DAO extends AbstractDao{

    public Task4DAO(Connection connection) {
        super(connection);
    }

    public List<Task4> task4List() throws SQLException {
        List<Task4> task4s = new ArrayList<>();

        String sql = "select company_name as company, array_agg(orders.order_id) as OrderIDs from customers " +
        "left join orders on customers.customer_id = orders.customer_id " +
        "group by company_name " +
        "order by company_name asc ";

        try(Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql)) {
            while(rs.next()) {
                Task4 task4 = new Task4(rs.getString("company"),
                                        rs.getArray("OrderIDs"));
                task4s.add(task4);
            }
        }
        return  task4s;
    }

    public List<Task4> task4ListFiltered(String company) throws SQLException {
        List<Task4> task4s = new ArrayList<>();
        String sql = "select company_name as company, array_agg(orders.order_id) as OrderIDs from customers " +
            "left join orders on customers.customer_id = orders.customer_id " +
            "group by company_name " +
            "having company_name like ? " +
            "order by company_name asc ";

        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + company + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Task4 task4 = new Task4(rs.getString("company"),
                                        rs.getArray("OrderIDs"));
                task4s.add(task4);
            }
        }
        return task4s;
    }
}



