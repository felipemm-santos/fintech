package br.com.fiap.fintech.model.transaction;

import br.com.fiap.fintech.model.record.*;

import java.time.LocalDate;
import java.time.Period;

public abstract class Transaction extends UserRecord {
    protected String transactionType; // Income, Expense
    protected String status; // PLANNED, PENDING, COMPLETED

    protected double amount;

    protected LocalDate dueDate; // Data prevista para acontecer
    protected LocalDate transactionDate; // Data em que aconteceu

    // Construtores
    protected Transaction(Integer userId){
        super(userId, RecordType.TRANSACTION);
    }

    protected Transaction(Integer userId,
                          String name,
                          double amount, String transactionType, String status, LocalDate dueDate, LocalDate transactionDate) {
        super(userId,name,RecordType.TRANSACTION);
        this.amount = amount;
        this.transactionType = transactionType;
        this.status = status;
        this.dueDate = dueDate;
        this.transactionDate = transactionDate;
    }

    // Métodos da classe

    public Period getTimeUntilDue() {
        /* Retorna quanto tempo falta para a data prevista de uma transação*/
        return Period.ZERO;
    }

    public LocalDate calculateNextDate() {
        /* Calcula a data em que a mesma transação será feita novamente*/

        // Lógica para calcular data

        System.out.println("Calculando data da próxima transação de nome " + this.name);
        return null;
    }

    // Getters

    public String getTransactionType() {
        return transactionType;
    }

    public String getStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    // Setters

    public Transaction setTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public Transaction setStatus(String status) {
        this.status = status;
        return this;
    }

    public Transaction setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public Transaction setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Transaction setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
        return this;
    }

    public Transaction setAsRecurring(boolean recurring,  Integer recurrenceInterval, String recurrenceUnit) {
        if (recurring){
        }else {
        }
        return this;
    }

}
