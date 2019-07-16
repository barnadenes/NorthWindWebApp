package com.codecool.web.model;

public class Task4 {
    private String company;
    private int[] order;

    public Task4(String company, int[] order) {
        this.company = company;
        this.order = order;
    }

    public String getCompany() {
        return company;
    }

    public int[] getOrder() {
        return order;
    }
}
