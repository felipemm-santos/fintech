package br.com.fintech.fase3.model.transaction;

import br.com.fintech.fase3.model.Record;

import java.time.LocalDate;

public class Expense extends Transaction {

    public Expense(String name, double amount, String type, String status) {
        super(name, amount, type, status);
    }

    // Implementação dos métodos da classe super
    @Override
    public Record updateRecord() {
        // Lógica para atualizar o registro
        System.out.println("Atualizando registro da despesa " +  this.name);
        return null;
    }

    // Getters
    public LocalDate getDueDate() {
        return dueDate;
    }

    // Setters
    public Expense setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }
}
