package br.com.fiap.fintech.model.transaction;

import br.com.fiap.fintech.model.record.UserRecord;

import java.time.LocalDate;

public class Income extends Transaction {
    // Construtores

    public Income(Integer userId, String name, double amount, String status,
                   LocalDate dueDate, LocalDate incomeDate) {
        super(userId, name, amount, TransactionType.INCOME, status, dueDate, incomeDate);
    }
}
