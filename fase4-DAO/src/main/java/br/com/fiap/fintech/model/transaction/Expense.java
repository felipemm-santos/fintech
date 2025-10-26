package br.com.fiap.fintech.model.transaction;

import br.com.fiap.fintech.model.record.UserRecord;

import java.time.LocalDate;

public class Expense extends Transaction {

    public Expense(Integer userId,String name, double amount, String status,
                   LocalDate dueDate, LocalDate expenseDate) {
        super(userId, name, amount, TransactionType.EXPENSE, status, dueDate, expenseDate);
    }

}
