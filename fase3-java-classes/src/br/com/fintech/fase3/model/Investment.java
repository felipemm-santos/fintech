package br.com.fintech.fase3.model;

import java.time.LocalDate;

public abstract class Investment extends Record {
    public Investment(String name, double amount,  LocalDate operationDate) {
        super(name,amount,operationDate);
    }

    public Investment(String name, String description, double amount,  LocalDate operationDate) {
        super(name,description,amount,operationDate);
    }

    public abstract double calculateReturn();
}
