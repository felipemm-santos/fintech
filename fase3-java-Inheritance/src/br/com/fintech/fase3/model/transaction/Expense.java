package br.com.fintech.fase3.model.transaction;

import br.com.fintech.fase3.model.record.UserRecord;

import java.time.LocalDate;

public class Expense extends Transaction {

    public Expense(String name, double amount, String transactionType, String status) {
        super(name, amount, transactionType, status);
    }

    // Implementação dos métodos da classe super
    @Override
    public UserRecord updateRecord() {
        // Lógica para atualizar o registro
        System.out.println("Atualizando registro da despesa " +  this.name);
        return this;
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
