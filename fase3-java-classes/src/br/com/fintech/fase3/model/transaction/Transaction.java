package br.com.fintech.fase3.model.transaction;

import br.com.fintech.fase3.model.Record;

import java.time.LocalDate;
import java.time.Period;

public abstract class Transaction extends Record {
    protected String type; // Income, Expense
    protected String status; // PLANNED, PENDING, COMPLETED

    protected double amount;

    protected LocalDate dueDate; // Data prevista para acontecer
    protected LocalDate transactionDate; // Data em que aconteceu

    protected boolean recurring; // É ou não recorrente
    protected int recurrenceInterval; // Intervalo de recorrência
    protected String recurrenceUnit; // Unidade de que mede o intervalo (ex. dias, semanas, meses, etc..)

    // Construtores
    public Transaction(){
        super();
    }
    public Transaction(String name, double amount, String type, String status) {
        super(name);
        this.amount = amount;
        this.type = type;
        this.status = status;
        this.recurring = false;
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

    public String getType() {
        return type;
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

    public boolean isRecurring() {
        return recurring;
    }

    public int getRecurrenceInterval() {
        return recurrenceInterval;
    }

    public String getRecurrenceUnit() {
        return recurrenceUnit;
    }

    // Setters

    public Transaction setType(String type) {
        this.type = type;
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

    public Transaction setRecurring(boolean recurring) {
        this.recurring = recurring;
        return this;
    }

    public Transaction setRecurrenceInterval(int recurrenceInterval) {
        this.recurrenceInterval = recurrenceInterval;
        return this;
    }

    public Transaction setRecurrenceUnit(String recurrenceUnit) {
        this.recurrenceUnit = recurrenceUnit;
        return this;
    }
}
