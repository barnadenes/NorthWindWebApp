package com.codecool.web.model;

import java.sql.Array;

public class Task4 {
    private String company;
    private Array order;

    public Task4(String company, Array order) {
        this.company = company;
        this.order = order;
    }

    public String getCompany() {
        return company;
    }

    public Array getOrder() {
        return order;
    }
}
