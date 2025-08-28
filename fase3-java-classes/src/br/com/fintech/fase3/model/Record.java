package br.com.fintech.fase3.model;

import java.time.LocalDate;

public abstract class Record {
    protected String name;
    protected String description;
    protected double amount;
    protected LocalDate operationDate;


    public Record(String name, double amount, LocalDate operationDate) {
        this.name = name;
        this.description = "";
        this.amount = amount;
        this.operationDate = operationDate;
    }

    public Record(String name, String description ,double amount, LocalDate operationDate) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.operationDate = operationDate;
    }

    //Métodos da classe
    public abstract Record updateRecord();

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getOperationDate() {
        return operationDate;
    }

    // Setters
    public Record setName(String name) {
        this.name = name;
        return this;
    }

    public Record setDescription (String description) {
        this.description = description;
        return this;
    }

    public Record setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public Record setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
        return this;
    }
}
