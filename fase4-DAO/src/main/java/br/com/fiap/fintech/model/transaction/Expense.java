package br.com.fiap.fintech.model.transaction;

import br.com.fiap.fintech.model.record.UserRecord;

import java.time.LocalDate;

public class Expense extends Transaction {

    public Expense(Long id, Long userId,String name, double amount,
                   String transactionType, String status) {
        super(id, userId, name, amount, transactionType,
                status);
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
