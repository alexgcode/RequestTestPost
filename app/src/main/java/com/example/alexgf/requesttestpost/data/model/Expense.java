package com.example.alexgf.requesttestpost.data.model;

public class Expense {

    private String description;
    private Double amount;

    public Expense(String description, Double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
