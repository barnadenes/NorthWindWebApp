package com.codecool.web.model;

public class Task2 {
    private String company;
    private int productNum;

    public Task2(String company, int productNum) {
        this.company = company;
        this.productNum = productNum;
    }

    public String getCompany() {
        return company;
    }

    public int getProductNum() {
        return productNum;
    }
}
